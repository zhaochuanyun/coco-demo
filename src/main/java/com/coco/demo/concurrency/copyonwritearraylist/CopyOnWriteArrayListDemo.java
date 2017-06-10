package com.coco.demo.concurrency.copyonwritearraylist;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.Lists;

/**
 * http://my.oschina.net/jielucky/blog/167198
 * 
 * @author Administrator
 *
 */
public class CopyOnWriteArrayListDemo {
    /**
     * 读线程
     * 
     * @author wangjie
     *
     */
    private static class ReadTask implements Runnable {
        int number;
        List<String> list;

        public ReadTask(int number, List<String> list) {
            this.number = number;
            this.list = list;
        }

        public void run() {
            for (String str : list) {
                System.out.println("#" + number + " read : " + str);
            }
        }
    }

    /**
     * 写线程
     * 
     * @author wangjie
     *
     */
    private static class WriteTask implements Runnable {
        int number;
        List<String> list;
        int index;

        public WriteTask(int number, List<String> list, int index) {
            this.number = number;
            this.list = list;
            this.index = index;
        }

        public void run() {
            String content = "write_" + index;
            System.out.println("#" + number + " write : " + content);
            list.remove(index);
            list.add(index, "write_" + index);
        }
    }

    public void run() {
        final int NUM = 10;
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < NUM; i++) {
            list.add("main_" + i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(NUM);
        for (int i = 0; i < NUM; i++) {
//            executorService.execute(new ReadTask(i, list));
            executorService.execute(new WriteTask(i, list, i));
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        executorService.execute(new ReadTask(99, list));
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new CopyOnWriteArrayListDemo().run();
    }
}
