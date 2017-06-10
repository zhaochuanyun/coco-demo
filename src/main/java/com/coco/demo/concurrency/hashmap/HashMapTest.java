package com.coco.demo.concurrency.hashmap;

import java.util.Map;

import com.google.common.collect.Maps;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("key1", 1);
        map.put(null, "null_1");
        map.put(null, "null_2");
        System.err.println(map);
    }

}
