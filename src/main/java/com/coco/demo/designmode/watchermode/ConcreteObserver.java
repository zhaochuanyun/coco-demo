package com.coco.demo.designmode.watchermode;

public class ConcreteObserver implements Observer {

    private String observerState;

    public String getObserverState() {
        return observerState;
    }

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }

    public void update(String state) {
        System.out.println("Received: new state is " + state);
        this.setObserverState(state);
    }

}
