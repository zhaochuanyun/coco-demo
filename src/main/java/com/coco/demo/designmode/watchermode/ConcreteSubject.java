package com.coco.demo.designmode.watchermode;

public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void changeState(String state) {
        setState(state);
        System.out.println("Notice: state of the subject has changed to " + getState());
        this.notifyObserver(getState());
    }

}
