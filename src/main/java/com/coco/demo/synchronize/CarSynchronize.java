package com.coco.demo.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarSynchronize {
    public static void main(String[] args) {
        Car car = new Car();
        Thread t1 = new Thread(new SpeedUp(car));
        Thread t2 = new Thread(new SpeedDown(car));
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(t1);
        es.execute(t2);
    }
}

class Car {

    private volatile int speed = 0;

    public synchronized void speedUp() throws InterruptedException {
        speed++;
        Thread.sleep(1000);
        Thread.yield();
        System.out.println("Now the car is speeding up to: " + getSpeed() + " miles");
    }

    public synchronized void speedDown() throws InterruptedException {
        speed--;
        Thread.sleep(1500);
        Thread.yield();
        System.err.println("Now the car is speeding down to: " + getSpeed() + " miles");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}

class SpeedUp implements Runnable {

    private Car car;

    public SpeedUp(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (true) {
            try {
                car.speedUp();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class SpeedDown implements Runnable {

    private Car car;

    public SpeedDown(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (true) {
            try {
                car.speedDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
