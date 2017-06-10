package com.coco.demo.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * To Add descript here 检测一个对象里面有两个Synchronized方法，是否可以同步执行
 * 
 * @see http://bjmike.iteye.com/blog/1346533
 * @author think
 * @since 2012-1-14
 */
public class SychronizedMethod {

    private int testNum = 10;

    public synchronized void testOne() {
        System.out.println("test1 entry");
        testNum = 11;
        System.out.println("test1 out");
    }

    public synchronized void testTwo() {
        System.out.println("test2 entry");
        testNum = 12;
        System.out.println("test2 out");
    }

    public static void main(String[] args) {
        SychronizedMethod sychronizedMethod = new SychronizedMethod();
        WorkHandlerOne handler1 = new WorkHandlerOne(sychronizedMethod);
        WorkHandlerTwo handler2 = new WorkHandlerTwo(sychronizedMethod);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executor.submit(new Thread(handler1));
            executor.submit(new Thread(handler2));
        }
    }

}
