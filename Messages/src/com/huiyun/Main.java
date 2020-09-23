package com.huiyun;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    // used by consumer to read message
    public synchronized String read() {
        while(empty) {
            try{
                wait();
            } catch(InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    // used by producer to write message
    public synchronized void write(String message) {
        while(!empty) {
            try{
                wait();
            } catch(InterruptedException e) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable {
    private Message message;
    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "This is the first line of message",
                "This is the second line of message",
                "This is the third line of message",
                "This is the forth line of message"
        };

        Random random = new Random();
        for(int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
        message.write("Finished.");
    }

}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for(String lastMsg = message.read(); !lastMsg.equals("Finished.");
            lastMsg = message.read()) {
            System.out.println(lastMsg);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}
