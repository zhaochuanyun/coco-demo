package com.coco.demo.helloworld;

import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {
        Object o = null;
        List<String> list = (List<String>) o;
        System.out.println(list == null);
    }

}
