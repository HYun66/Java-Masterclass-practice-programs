package com.huiyun;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private Lock reentrantLock;
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.reentrantLock = new ReentrantLock();
    }

//    public void deposit(double amount) {
//        reentrantLock.lock();
//        try{
//            balance += amount;
//        } finally {
//            reentrantLock.unlock();
//        }
//    }
//
//    public void withdraw(double amount) {
//        reentrantLock.lock();
//        try{
//            balance -= amount;
//        } finally {
//            reentrantLock.unlock();
//        }
//    }


    public void deposit(double amount) {
        boolean status = false;
        try {
            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try{
                    balance += amount;
                    status = true;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println("Time out, can't get the lock");
            }

        } catch (InterruptedException e) {

        }

        System.out.println("Deposit status : " + status + " " + balance);
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try{
                    balance -= amount;
                    status = true;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println("Time out, can't get the lock");
            }

        } catch (InterruptedException e) {

        }

        System.out.println("Withdraw status : " + status + " " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number: " + accountNumber);
    }
}
