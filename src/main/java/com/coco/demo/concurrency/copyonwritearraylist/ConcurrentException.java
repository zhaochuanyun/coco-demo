package com.coco.demo.concurrency.copyonwritearraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @see http://www.cnblogs.com/dolphin0520/p/3933551.html
 * @author zhaochuanyun379
 *
 */
public class ConcurrentException {

    static void test1() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                list.remove(integer);
                // iterator.remove();
            }
        }
    }

    static void test2() {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread() {
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    System.out.println(this.getName() + " read : " + integer);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        };
        Thread thread2 = new Thread() {
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    if (integer == 2) {
                        iterator.remove();
                        System.out.println(this.getName() + " remove : " + integer);
                    }
                }
            };
        };
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        test2();
    }

}
