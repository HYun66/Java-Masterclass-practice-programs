package com.huiyun;

public class Main {

    public static void main(String[] args) {
        Account account1 = new Account("123456", 0.00, "Sallie Niu", "hy@123.com","04103485");
        System.out.println(account1.getBalance());

        account1.withdrawal(10.0);
        account1.deposit(50.0);
        account1.withdrawal(20.0);

        Account account2 = new Account();
        System.out.println(account2.getCustomerName());

        Account account3 = new Account("Mike", "mike@gmail.com", "04938345");
        System.out.println(account3.getNumber() + " name " + account3.getCustomerName());
    }
}
