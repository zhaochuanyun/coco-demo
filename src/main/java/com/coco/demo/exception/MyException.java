package com.coco.demo.exception;

public class MyException {

    public static int getNum() {
        String str = "str";
        int num = 0;
        try {
            for (int i = 0; i < 5; i++) {
                num = Integer.valueOf(str);
            }
        } catch (Exception e) {
            num = -1;
        }
        num = 100;
        return num;
    }

    public static void main(String[] args) {
        int num = getNum();
        System.out.println(num);
    }

}
