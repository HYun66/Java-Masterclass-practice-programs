package com.huiyun;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.huiyun.Main.EOF;

import static com.huiyun.ThreadColor.*;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
	    List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

	    MyProducer producer = new MyProducer(buffer, ANSI_BLUE, bufferLock);
	    MyConsumer consumer1 = new MyConsumer(buffer, ANSI_GREEN, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_RED, bufferLock);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ANSI_PURPLE + "Printing from the Callable class");
                return "This is the callable result";
            }
        });
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task is interrupted");
        }

        executorService.shutdown();

    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for(String num : nums) {
            try{
                System.out.println(color + "Adding ... " + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF to exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }

    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        int counter = 0;
        while(true) {
            if(bufferLock.tryLock()) {
                try {
                    if(buffer.isEmpty()) {
//                    bufferLock.unlock();
                        continue;
                    }
                    System.out.println(color + "The counter: " + counter);
                    if(buffer.get(0).equals(EOF)){
                        System.out.println(color + "Exiting");
//                    bufferLock.unlock();
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            }else {
                counter++;
            }


        }
    }
}