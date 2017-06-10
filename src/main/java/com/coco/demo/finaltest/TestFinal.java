package com.coco.demo.finaltest;

public class TestFinal {

    public static void main(String[] args) {
        final Integer[] intArray1 = new Integer[5];
        final Integer[] intArray2 = new Integer[5];
        for (int i = 0; i < 5; i++) {
            intArray1[i] = i;
            intArray2[i] = 2 * i;
        }
        for (int i = 0; i < 5; i++) {
            intArray2[i] = i;
            intArray1[i] = 2 * i;
        }
        System.out.println(intArray1);
        System.out.println(intArray2);
    }

}
