package com.coco.demo.string;

public class TestStringBuffer {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        int i = sb.lastIndexOf("|");
        System.out.println(i);
        sb.deleteCharAt(i);
    }

}
