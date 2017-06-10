package com.coco.demo.designmode.watchermode;

import java.util.List;

import com.google.common.collect.Lists;

public abstract class Subject {

    public List<Observer> list = Lists.newArrayList();

    public void attach(Observer observer) {
        this.list.add(observer);
    }

    public void detach(Observer observer) {
        this.list.remove(observer);
    }

    public void notifyObserver(String state) {
        for (Observer observer : list) {
            observer.update(state);
        }
    }

}
