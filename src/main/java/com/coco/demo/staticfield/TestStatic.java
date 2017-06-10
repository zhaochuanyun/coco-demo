package com.coco.demo.staticfield;

public class TestStatic {
    public static String str;
    public static int i;

    public TestStatic(String str) {
        i++;
        this.str = str;
        System.out.println("index " + i + " : " + str);
    }

    public static void main(String[] args) {
    }
}
