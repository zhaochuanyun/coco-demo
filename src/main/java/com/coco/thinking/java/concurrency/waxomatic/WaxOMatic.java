//: concurrency/waxomatic/WaxOMatic.java
// Basic task cooperation.
package com.coco.thinking.java.concurrency.waxomatic;

import java.util.concurrent.*;

import static thinking.in.net.mindview.util.Print.*;

class Car {
    private boolean waxOn = false;

    /**
     * 打蜡操作
     */
    public synchronized void waxed() {
        waxOn = true; // Ready to buff
        notifyAll();
    }

    /**
     * 抛光操作
     */
    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        notifyAll();
    }

    /**
     * 等待打蜡
     * 
     * @throws InterruptedException
     */
    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) {
            System.err.println("waxOn == false, 等待打蜡");
            wait();
        }
    }

    /**
     * 等待抛光
     * 
     * @throws InterruptedException
     */
    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true) {
            System.err.println("waxOn == true, 等待抛光");
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForBuffing();

                print("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();

                print("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
} /*
   * Output: (95% match) Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On!
   * Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off!
   * Wax On! Wax Off! Wax On! Wax Off! Wax On! Exiting via interrupt Ending Wax On task Exiting via
   * interrupt Ending Wax Off task
   */// :~
