package com.coco.demo.designmode.produceconsume;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Java线程：并发协作-生产者消费者模型 http://lavasoft.blog.51cto.com/62575/221932/
 * 
 * 2017年09月05日18:02:27 notifyAll调用发出后, 等待的线程(wait)并不一定能抢占到锁！！！
 * 
 * @author leizhimin 2009-11-4 14:54:36
 */
public class ProduceConsume {
    public static void main(String[] args) {
        Repertory Repertory = new Repertory(30);
        Thread c1 = new Thread(new Consumer(50, Repertory), "c1");
        Thread c2 = new Thread(new Consumer(20, Repertory), "c2");
        Thread c3 = new Thread(new Consumer(30, Repertory), "c3");
        Thread p1 = new Thread(new Producer(10, Repertory), "p1");
        Thread p2 = new Thread(new Producer(10, Repertory), "p2");
        Thread p3 = new Thread(new Producer(10, Repertory), "p3");
        Thread p4 = new Thread(new Producer(10, Repertory), "p4");
        Thread p5 = new Thread(new Producer(10, Repertory), "p5");
        Thread p6 = new Thread(new Producer(10, Repertory), "p6");
        Thread p7 = new Thread(new Producer(80, Repertory), "p7");

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(c1);
        executor.execute(c2);
        executor.execute(c3);
        executor.execute(p1);
        executor.execute(p2);
        executor.execute(p3);
        executor.execute(p4);
        executor.execute(p5);
        executor.execute(p6);
        executor.execute(p7);
        executor.shutdown();
    }
}

/**
 * 仓库
 */
class Repertory {
    public static final int MAX_SIZE = 100; // 最大库存量
    public volatile int curNum; // 当前库存量

    Repertory() {
    }

    Repertory(int curNum) {
        this.curNum = curNum;
    }

    private void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 生产指定数量的产品
     * 
     * @param needNum
     */
    public synchronized void produce(int needNum) {
        // 测试是否需要生产
        while (needNum + curNum > MAX_SIZE) {
            try {
                System.out.println("[生产者]" + Thread.currentThread().getName() + "- 现有库存量 -> " + curNum + ", 要生产的产品数量为：" + needNum + "，超过库存总容量：" + MAX_SIZE
                        + "，暂时不能执行生产任务! -> 进入wait()" + "\n");
                // 当前的生产线程等待
                wait();
                sleep();
                System.out.println("[生产者]" + Thread.currentThread().getName() + " - 结束wait()");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 满足生产条件，则进行生产，这里简单的更改当前库存量
        curNum += needNum;
        System.out.println("[生产者]" + Thread.currentThread().getName() + " - 生产了: " + needNum + "个产品，现有库存量 -> " + curNum + "\n");
        // 唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }

    /**
     * 消费指定数量的产品
     * 
     * @param needNum
     */
    public synchronized void consume(int needNum) {
        // 测试是否可消费
        while (needNum > curNum) {
            try {
                System.err.println(
                        "[消费者]" + Thread.currentThread().getName() + " - 现有库存量 -> " + curNum + ", 要消费的产品数量为：" + needNum + "，暂时不能执行消费任务! -> 进入wait()" + "\n");
                // 当前的生产线程等待
                wait();
                sleep();
                System.err.println("[消费者]" + Thread.currentThread().getName() + " - 结束wait()");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 满足消费条件，则进行消费，这里简单的更改当前库存量
        curNum -= needNum;
        System.err.println("[消费者]" + Thread.currentThread().getName() + " - 消费了: " + needNum + "个产品，现有库存量 -> " + curNum + "\n");
        // 唤醒在此对象监视器上等待的所有线程
        notifyAll();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private int needNum; // 生产产品的数量
    private Repertory repertory; // 仓库

    Producer(int needNum, Repertory repertory) {
        this.needNum = needNum;
        this.repertory = repertory;
    }

    public void run() {
        // 生产指定数量的产品
        repertory.produce(needNum);
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    private int needNum; // 生产产品的数量
    private Repertory repertory; // 仓库

    Consumer(int needNum, Repertory repertory) {
        this.needNum = needNum;
        this.repertory = repertory;
    }

    public void run() {
        // 消费指定数量的产品
        repertory.consume(needNum);
    }
}
