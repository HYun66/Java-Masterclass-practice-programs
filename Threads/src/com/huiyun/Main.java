package com.huiyun;
import static com.huiyun.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        AnotherThread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start(); // Hello from == Another Thread ==
//         lo from main (why don't want to call run directly)

        new Thread() {
            public void run() {
                System.out.println(ANSI_BLUE + "Hello from the anonymous class thread.");
            }
        }.start();

        // creating thread by subclassing the thread class
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        // have an anonymous class implements runnable and pass the instance of it to the thread constructor
        Thread myRunnableThread1 = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from anonymous class's implementation of run()" );
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_CYAN + "AnotherThread terminated or timed out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_CYAN + "I couldn't wait after all, I was interrupted.");
                }
            }
        });
        myRunnableThread1.start();
        //anotherThread.interrupt();

        System.out.println(ANSI_GREEN + "Hello again from the main thread.");

    }
}

// join one thread to a second thread, the first thread will wait for the second thread
// to terminate and then it will continue to execute