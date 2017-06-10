package com.coco.demo.designmode.factorymode.abstractfactory;

public class FactoryB implements AbstractFactory {
    public Plant createPlant() {
        return new PlantB();
    }

    public Fruit createFruit() {
        return new FruitB();
    }
}
