package com.coco.demo.wait;

/**
 * http://blog.csdn.net/lingzhm/article/details/44940823
 * 
 * @author mvpzhao
 *
 */
class WaitNotify {
    public static void main(String args[]) {
        final byte res[] = { 0 };// 以该对象为共享资源
        NumPrint np_a = new NumPrint(1, res);
        NumPrint np_b = new NumPrint(2, res);
        new Thread(np_a, "A").start();
        new Thread(np_b, "B").start();
    }
}

class NumPrint implements Runnable {
    private int number;
    public volatile byte res[];
    public static int count = 5;

    public NumPrint(int number, byte a[]) {
        this.number = number;
        res = a;
    }

    public void run() {
        synchronized (res) {
            while (count-- > 0) {
                try {
                    res.notifyAll();// 唤醒等待res资源的线程，把锁交给线程（该同步锁执行完毕自动释放锁）
                    System.out.println("------线程" + Thread.currentThread().getName() + ": wait()");
                    res.wait();// 释放CPU控制权，释放res的锁，本线程阻塞，等待被唤醒。
                    System.out.println("------线程" + Thread.currentThread().getName() + "获得锁，wait()后的代码继续运行：" + number);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } // end of while
            return;
        } // synchronized
    }
}
