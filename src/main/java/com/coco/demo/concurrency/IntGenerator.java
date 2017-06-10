package com.coco.demo.concurrency;

public abstract class IntGenerator {

    public volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        this.canceled = true;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

}
