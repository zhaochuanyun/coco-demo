package com.coco.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();
    }

}
