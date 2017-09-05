package com.coco.demo.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import headfirst.singleton.dcl.Singleton;

public class TestInvoke {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("headfirst.singleton.dcl.Singleton");
//        Method method = clazz.getDeclaredMethod("print");
//        method.invoke(new TestClass("outer"));
//
//        Class<?> innerClass = Class.forName("com.coco.test.invoke.TestClass$TestInnerClass");
//        System.out.println(innerClass);
        
        Constructor<?>[] cons = clazz.getDeclaredConstructors();
        cons[0].setAccessible(true);
        Object obj1 = clazz.newInstance();
        Object obj2 = clazz.newInstance();
        System.out.println(obj1 == obj2);
    }

}
