package com.coco.demo.concurrency.lock;

public class TwoSynchronizedMethodInOneClassTest {
    private static int counter = 0;

    public synchronized void a() {
        while (true) {
            // Once this method is called by a thread, it will hold the lock, and not
            // give way to other access thead.
            System.out.println("AA---" + counter++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void b() {
        while (true) {
            System.out.println("---BB" + counter++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // single instance will use the same lock object.
    public static TwoSynchronizedMethodInOneClassTest instance = new TwoSynchronizedMethodInOneClassTest();

    public static void main(String[] args) {
        Thread a = new Thread() {
            public void run() {
                TwoSynchronizedMethodInOneClassTest.instance.a();
            }
        };
        Thread b = new Thread() {
            public void run() {
                TwoSynchronizedMethodInOneClassTest.instance.b(); 
                // The same lock will not run to state of idel, can method b() can never be accessed.
                // new T() will ues a different lock object, so method b() can be accessed.
            }
        };
        a.start();
        b.start();
    }
}
