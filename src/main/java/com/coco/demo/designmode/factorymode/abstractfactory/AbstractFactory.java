package com.coco.demo.designmode.factorymode.abstractfactory;

//抽象工厂方法      
public interface AbstractFactory {
    public Plant createPlant();

    public Fruit createFruit();
}
