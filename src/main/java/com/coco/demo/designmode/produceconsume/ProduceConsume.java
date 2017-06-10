package com.coco.demo.designmode.produceconsume;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java线程：并发协作-生产者消费者模型 http://lavasoft.blog.51cto.com/62575/221932/
 * 
 * @author leizhimin 2009-11-4 14:54:36
 */
public class ProduceConsume {
    public static void main(String[] args) {
        Repertory Repertory = new Repertory(30);
        Consumer c1 = new Consumer(50, Repertory);
        Consumer c2 = new Consumer(20, Repertory);
        Consumer c3 = new Consumer(30, Repertory);
        Producer p1 = new Producer(10, Repertory);
        Producer p2 = new Producer(10, Repertory);
        Producer p3 = new Producer(10, Repertory);
        Producer p4 = new Producer(10, Repertory);
        Producer p5 = new Producer(10, Repertory);
        Producer p6 = new Producer(10, Repertory);
        Producer p7 = new Producer(80, Repertory);

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

    /**
     * 生产指定数量的产品
     * 
     * @param needNum
     */
    public synchronized void produce(int needNum) {
        // 测试是否需要生产
        while (needNum + curNum > MAX_SIZE) {
            System.err.println("要生产的产品数量为：" + needNum + "，超过剩余库存量：" + (MAX_SIZE - curNum) + "，暂时不能执行生产任务!");
            try {
                // 当前的生产线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 满足生产条件，则进行生产，这里简单的更改当前库存量
        curNum += needNum;
        System.out.println("已经生产了" + needNum + "个产品，现仓储量为" + curNum);
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
            System.err.println("要消费的产品数量为：" + needNum + "，超过现仓储量：" + (curNum) + "，暂时不能执行消费任务!");
            try {
                // 当前的生产线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 满足消费条件，则进行消费，这里简单的更改当前库存量
        curNum -= needNum;
        System.out.println("已经消费了" + needNum + "个产品，现仓储量为" + curNum);
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
