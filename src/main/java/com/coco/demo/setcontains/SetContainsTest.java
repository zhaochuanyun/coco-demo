package com.coco.demo.setcontains;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class SetContainsTest {

    public static void main(String[] args) {
        Map map = Maps.newHashMap();
        Set<String> set = Sets.newHashSet();
        set.add(new String("123"));
        set.add(new String("456"));
        System.out.println(set.contains(new String("123")));
    }

}
