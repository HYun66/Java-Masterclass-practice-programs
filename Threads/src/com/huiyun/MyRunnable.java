package com.huiyun;
import static com.huiyun.ThreadColor.*;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run() ");
    }
}
