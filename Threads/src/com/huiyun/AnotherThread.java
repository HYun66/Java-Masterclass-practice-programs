package com.huiyun;
import static com.huiyun.ThreadColor.*;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from " + currentThread().getName() );

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_RED + "Another thread woke me up");
            return;
        }

        System.out.println(ANSI_RED + "5 seconds have passed and I'm awake");
    }
}
