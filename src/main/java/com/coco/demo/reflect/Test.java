package com.coco.demo.reflect;

public class Test {
    
    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("a");
        System.out.println(ReflectTest.toString(car));
        test(car);
        System.out.println(car);
    }

    public static void test(Car car) {
        car.setColor("yellow");
    }
}
