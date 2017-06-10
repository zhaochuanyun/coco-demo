package com.coco.demo.string;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringBufferAndStringBuilder {

    static Lock lock = new ReentrantLock();

    static final int MAX = 100000;

    public static void main(String[] args) {
        String str = "initial";
        StringBuffer sbf = new StringBuffer(str);
        StringBuilder sbd = new StringBuilder(str);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < MAX; i++) {
            executor.execute(new ThreadTest(sbf, i));
            executor.execute(new ThreadTest(sbd, i));
        }

        executor.shutdown();

        check(sbf);
        check(sbd);
    }

    static void check(Object object) {
        String str = object.toString();
        boolean result = true;
        for (int i = 0; i < MAX; i++) {
            if (!str.contains(String.valueOf(i))) {
                result = false;
                break;
            }
        }
        if (result) {
            System.err.println(object.getClass().toString() + " : thead safe");
        } else {
            System.err.println(object.getClass().toString() + " : thead unsafe");
        }
    }

    static void append(Appendable sb, int index) {
        try {
            // lock.lock();
            sb.append("-" + index);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // lock.unlock();
        }
    }

}

class ThreadTest implements Runnable {

    private Appendable sb;
    private int index;

    public ThreadTest(Appendable sb, int index) {
        super();
        this.sb = sb;
        this.index = index;
    }

    @Override
    public void run() {
        StringBufferAndStringBuilder.append(sb, index);
        Thread.yield();
    }

}
