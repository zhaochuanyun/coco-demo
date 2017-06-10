package com.coco.demo.staticfield;

/**
 * 如果一个类中包含静态成员变量，那么这个变量会归所有的实现类所共用
 * 
 * @author Administrator
 *
 */
public class MainMethod {
    public static void main(String[] args) {
        TestStatic test1 = new TestStatic("one");
        TestStatic test2 = new TestStatic("two");
        System.out.println(test1.str);
        System.out.println(test1.i);
    }

}
