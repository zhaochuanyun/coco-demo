package com.coco.demo.wait;

/**
 * http://www.cnblogs.com/hapjin/p/5492645.html
 * 
 * @author mvpzhao
 *
 */
public class WaitNofiy1 {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();

        // NotifyThread notifyThread = new NotifyThread(lock);
        // notifyThread.start();

        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();
    }
}

class ThreadA extends Thread {
    private volatile Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}

class SynNotifyMethodThread extends Thread {
    private volatile Object lock;

    public SynNotifyMethodThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }
}

class Service {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
                lock.wait();
                System.out.println("  end wait() ThreadName=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("  end notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
