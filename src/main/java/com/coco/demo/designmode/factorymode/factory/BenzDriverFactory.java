package com.coco.demo.designmode.factorymode.factory;

public class BenzDriverFactory implements DriverFactory {

    public Car driverCar() {
        return new BenzCar();
    }

}
