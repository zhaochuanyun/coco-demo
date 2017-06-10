package com.coco.demo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TicketThread extends Thread {
    private static int count = 0;
    private final int id = count++;
    private int ticketNum = 10;

    @Override
    public void run() {
        while (this.ticketNum > 0) {
            System.out.println("thread[" + id + "]卖票：ticket" + this.ticketNum--);
        }
    }

}

class TicketRunnable implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private int ticketNum = 10;

    @Override
    public void run() {
        while (this.ticketNum > 0) {
            System.out.println("runnable[" + id + "]卖票：ticket" + this.ticketNum--);
        }
    }

}

public class RunnableAndThread {

    public static void main(String[] args) throws InterruptedException {
        TicketThread t = new TicketThread();
        ExecutorService exec = Executors.newCachedThreadPool();

        TicketRunnable r = new TicketRunnable();
        exec.submit(new Thread(r));
        exec.submit(new Thread(r));

    }

}
