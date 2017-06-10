package com.coco.demo.staticblock;

/**
 * static块的作用 http://www.java3z.com/cwbwebhome/article/article8/81101.html?id=2497
 * 
 * @author Administrator
 *
 */
public class StaticBlock {
    static int i = 20;

    static {
        i = 10;
    }

    public static void main(String[] args) {
        System.out.println(i);
    }
}
