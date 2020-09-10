package com.huiyun;

public class Rectangle extends Shape {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle() {
        this(0,0); // calls 2nd constructor
    }

    // 2nd constructor
    public Rectangle(int width, int height) {
        this(0,0, width,height); // calls 3rd constructor
    }

    // 3rd constructor
    public Rectangle(int x, int y, int width, int height) {
        // initialize variables
        super(x, y);
        this.width = width;
        this.height = height;
    }
}
