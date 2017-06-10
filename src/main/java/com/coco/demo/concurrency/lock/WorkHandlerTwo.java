package com.coco.demo.concurrency.lock;

/**
 * To Add descript here
 *
 * @author think
 * @since 2012-1-14
 */
public class WorkHandlerTwo implements Runnable {

    private SychronizedMethod syn;

    // AtomicInteger id = new AtomicInteger();

    WorkHandlerTwo(SychronizedMethod syn) {
        this.syn = syn;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        syn.testTwo();
    }

}
