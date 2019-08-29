package com.coco.demo.concurrency.copyonwritearraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://juejin.im/post/5aaa2ba8f265da239530b69e
 */
public class IteratorTest {

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iter = list.iterator();

        // 存放10个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行10个任务(我当前正在迭代集合（这里模拟并发中读取某一list的场景）)
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    while (iter.hasNext()) {
                        System.err.println(iter.next());
                    }
                }
            });
            service.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("121");// 添加数据
                }
            });
        }

        // 执行10个任务
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("121");// 添加数据
                }
            });
            service.execute(new Runnable() {
                @Override
                public void run() {
                    while (iter.hasNext()) {
                        System.err.println(iter.next());
                    }
                }
            });
        }

        System.err.println(Arrays.toString(list.toArray()));

    }
}
