package com.coco.demo.aop;

public class CustomerServiceImpl implements ICustomerService {

    public void someMethod() {

        System.out.println("Inside CustomerServiceImpl.someMethod()");

        someInnerMethod();

    }

    public void someInnerMethod() {

        System.out.println("Inside CustomerServiceImpl.someInnerMethod()");

    }

}
