package com.huiyun;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(50, true);
        System.out.println("initial page count = " + printer.getPagesPrinted());
        int pagePrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagePrinted + " new total print count for printer = " + printer.getPagesPrinted());
        pagePrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagePrinted + " new total print count for printer = " + printer.getPagesPrinted());

    }
}
