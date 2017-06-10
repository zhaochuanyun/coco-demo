package com.coco.demo.designmode.factorymode.factory;

public class BmwDriverFactory implements DriverFactory {

    public Car driverCar() {
        return new BmwCar();
    }

}
