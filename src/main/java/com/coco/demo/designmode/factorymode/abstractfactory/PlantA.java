package com.coco.demo.designmode.factorymode.abstractfactory;

public class PlantA implements Plant {
    public PlantA() {
        System.out.println("create PlantA !");
    }

    public void doSomething() {
        System.out.println(" PlantA do something ...");
    }
}
