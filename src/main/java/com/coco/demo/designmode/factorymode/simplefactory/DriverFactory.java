package com.coco.demo.designmode.factorymode.simplefactory;

//工厂类角色
public class DriverFactory {

    // 工厂方法
    // 注意 返回类型为抽象产品角色
    public static Car driverCar(String s) throws Exception {
        // 判断逻辑，返回具体的产品角色给Client
        if (s.equalsIgnoreCase("Benz")) {
            return new BenzCar();
        } else if (s.equalsIgnoreCase("Bmw")) {
            return new BmwCar();
        } else {
            throw new Exception();
        }
    }

}