package com.coco.headfirst.combining.observer;

public interface QuackObservable {
    public void registerObserver(Observer observer);

    public void notifyObservers();
}
