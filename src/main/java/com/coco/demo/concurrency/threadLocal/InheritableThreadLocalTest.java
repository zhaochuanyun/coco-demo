package com.coco.demo.concurrency.threadLocal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @see https://juejin.im/post/5a9a1bc36fb9a028d5669144
 */
public class InheritableThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static InheritableThreadLocal<Integer> inheritableThreadLocal =
            new InheritableThreadLocal<>();

    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();

    public static void main(String[] args) {
        // 父线程
        threadLocal.set(1);
        inheritableThreadLocal.set(1);
        //结果：pool-1-thread-1:null/1
        threadFactory.newThread(() -> System.out.println(Thread.currentThread().getName() + ":"
                + threadLocal.get() + "/"
                + inheritableThreadLocal.get())).start();
    }
}
