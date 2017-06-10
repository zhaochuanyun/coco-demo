package com.coco.demo.concurrency;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Sets;

class NumThread implements Runnable {
    int num = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            num += 1;
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class MultiNum {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Set<Integer> set = Sets.newTreeSet();
        for (int i = 0; i < 1000; i++) {
            NumThread t = new NumThread();
            exec.submit(new Thread(t));
            exec.submit(new Thread(t));
            TimeUnit.MILLISECONDS.sleep(10);
            set.add(t.getNum());
        }
        for (int num : set) {
            System.out.println(num);
        }
    }

}
