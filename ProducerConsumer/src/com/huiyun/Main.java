package com.huiyun;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.huiyun.Main.EOF;

import static com.huiyun.ThreadColor.*;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
	    List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
	    MyProducer producer = new MyProducer(buffer, ANSI_BLUE, bufferLock);
	    MyConsumer consumer1 = new MyConsumer(buffer, ANSI_GREEN, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ANSI_RED, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();


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
                buffer.add(num);
                bufferLock.unlock();

                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF to exiting...");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();

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
        while(true) {
            bufferLock.lock();
                if(buffer.isEmpty()) {
                    bufferLock.unlock();
                    continue;
                }
                if(buffer.get(0).equals(EOF)){
                    System.out.println(color + "Exiting");
                    bufferLock.unlock();
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            bufferLock.unlock();

        }
    }
}