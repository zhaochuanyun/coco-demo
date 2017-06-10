package com.coco.demo.invoke;

import java.lang.reflect.Method;

public class TestInvoke {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = TestClass.class;
        Method method = clazz.getDeclaredMethod("print");
        method.invoke(new TestClass("outer"));

        Class<?> innerClass = Class.forName("com.coco.test.invoke.TestClass$TestInnerClass");
        System.out.println(innerClass);
    }

}
