package com.coco.demo.designmode.factorymode.abstractfactory;

//具体工厂方法      
public class FactoryA implements AbstractFactory {
    public Plant createPlant() {
        return new PlantA();
    }

    public Fruit createFruit() {
        return new FruitA();
    }
}