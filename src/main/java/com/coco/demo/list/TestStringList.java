package com.coco.demo.list;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class TestStringList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("一");
        list.add("二");
        list.add(0, "零");
        System.out.println(list.toString());
        list.set(1, null);
        System.out.println(list.toString());

        List<String> aList = Lists.newArrayList();
        aList.add("一");
        aList.add("二");
        aList.add("三");
        aList.add("四");

        System.out.println(aList.contains("一"));

        aList.removeAll(list);

        System.out.println(aList.toString());
    }

}
