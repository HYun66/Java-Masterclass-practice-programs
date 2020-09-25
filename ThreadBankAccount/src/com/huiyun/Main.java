package com.huiyun;

public class Main {

    public static void main(String[] args) {
	    BankAccount account1 = new BankAccount("10001", 1000.00);

//	    Thread thread1 = new Thread() {
//	        public void run() {
//	            account1.deposit(300.00);
//	            account1.withdraw(100.00);
//            }
//        };
//
//        Thread thread2 = new Thread() {
//            public void run() {
//                account1.withdraw(10.00);
//                account1.deposit(20.00);
//            }
//        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account1.deposit(300.00);
                account1.withdraw(100.00);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account1.withdraw(10.00);
                account1.deposit(20.00);
            }
        });

        thread1.start();
        thread2.start();
    }
}
