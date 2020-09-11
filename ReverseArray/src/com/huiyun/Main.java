package com.huiyun;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] array = {1, 3, 5, 7, 9};
        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);
        System.out.println("Reversed Array = " + Arrays.toString(array));
    }

    public static void reverse(int[] array) {
        int maxindex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int tmp = array[i];
            array[i] = array[maxindex - i];
            array[maxindex - i] = tmp;
        }
    }
}
