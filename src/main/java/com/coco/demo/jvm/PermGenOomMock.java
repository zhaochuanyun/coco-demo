package com.coco.demo.jvm;

import java.util.List;

import com.google.common.collect.Lists;

public class PermGenOomMock {
    public static void main(String[] args) {
        List<Class> classLoaderList = Lists.newArrayList();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            while (true) {
                classLoaderList.add(loader.loadClass("com.coco.demo.jvm.Test"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Test {
    private static String testStr = new String("testStr");
}
