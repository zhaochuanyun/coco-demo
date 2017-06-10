package com.coco.demo.designmode.watchermode;

public class Client {

    public static void main(String[] args) {
        ConcreteObserver observer = new ConcreteObserver();

        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(observer);

        subject.changeState("007");
    }

}
