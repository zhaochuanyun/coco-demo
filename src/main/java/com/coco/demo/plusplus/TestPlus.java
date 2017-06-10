package com.coco.demo.plusplus;

public class TestPlus {
    public static void main(String[] args) {
        int initialNum = 0;
        System.out.println("  initialNum = " + initialNum);
        System.out.println("++initialNum = " + ++initialNum);
        initialNum = 0;
        System.out.println("initialNum++ = " + initialNum++);
        initialNum = 0;
        int plusNum = ++initialNum;
        System.out.println("     plusNum = " + plusNum);
        System.out.println("  initialNum = " + initialNum);
        initialNum = 0;
        int numPlus = initialNum++;
        System.out.println("     numPlus = " + numPlus);
        System.out.println("  initialNum = " + initialNum);
    }
}
