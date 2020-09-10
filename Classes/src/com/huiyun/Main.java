package com.huiyun;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        Car holden = new Car();
        System.out.println("Model is " + porsche.getModel());
        porsche.setModel("Carrera");
        holden.setModel("avd");
        System.out.println("Model is " + porsche.getModel());
        System.out.println("Model is " + holden.getModel());
    }
}
