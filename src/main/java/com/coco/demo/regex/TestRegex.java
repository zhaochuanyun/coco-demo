package com.coco.demo.regex;

import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[0-9]+_[0-9]+(,[0-9]+_[0-9])*");
        System.out.println(pattern.matcher("25_10,").matches());
    }

}
