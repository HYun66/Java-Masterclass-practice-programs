package com.huiyun;

public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
	// write your code here
    }

    private static class Thread1 extends Thread {
        public void run () {
            synchronized (lock1) {
                System.out.println("Thread 1: holding lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1: waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: holding lock1 and lock2");
                }
                System.out.println("Thread 1: released lock2");
            }
            System.out.println("Thread 1: released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run () {
            synchronized (lock2) {
                System.out.println("Thread 2: holding lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2: waiting for lock2");
                synchronized (lock1) {
                    System.out.println("Thread 2: holding lock1 and lock2");
                }
                System.out.println("Thread 2: released lock2");
            }
            System.out.println("Thread 2: released lock2. Exiting...");
        }
    }
}

