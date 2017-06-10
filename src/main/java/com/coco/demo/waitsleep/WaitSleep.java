package com.coco.demo.waitsleep;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class WaitSleep {

    private List synchronizedList;

    public WaitSleep() {
        // create a new synchronized list to be used
        synchronizedList = Collections.synchronizedList(new LinkedList());
    }

    // method used to remove an element from the list
    public String removeElement() throws InterruptedException {
        synchronized (synchronizedList) {

            // while the list is empty, wait
            while (synchronizedList.isEmpty()) {
                System.out.println("[" + Thread.currentThread().getName() + "] : List is empty...");
                synchronizedList.wait();
                System.out.println("[" + Thread.currentThread().getName() + "] : Waiting...");
            }
            String element = (String) synchronizedList.remove(0);

            return element;
        }
    }

    // method to add an element in the list
    public void addElement(String element) {
        System.err.println("[" + Thread.currentThread().getName() + "] : Opening...");
        synchronized (synchronizedList) {

            // add an element and notify all that an element exists
            synchronizedList.add(element);
            System.err.println("[" + Thread.currentThread().getName() + "] : New Element : '"
                    + element + "'");

            synchronizedList.notifyAll();
            System.err.println("[" + Thread.currentThread().getName() + "] : notifyAll called!");
        }
        System.err.println("[" + Thread.currentThread().getName() + "] : Closing...");
    }

    public static void main(String[] args) {
        final WaitSleep demo = new WaitSleep();

        Runnable runA = new Runnable() {
            public void run() {
                try {
                    String item = demo.removeElement();
                    System.out.println("[" + Thread.currentThread().getName()
                            + "] : Remove Element : '" + item + "'");
                } catch (InterruptedException ix) {
                    System.out.println("[" + Thread.currentThread().getName()
                            + "] : Interrupted Exception!");
                } catch (Exception x) {
                    System.out.println("[" + Thread.currentThread().getName()
                            + "] : Exception thrown.");
                }
            }
        };

        Runnable runB = new Runnable() {
            // run adds an element in the list and starts the loop
            public void run() {
                demo.addElement("Hello!");
            }
        };

        try {
            Thread threadA1 = new Thread(runA, "A1");
            threadA1.start();

            Thread.sleep(500);

            Thread threadA2 = new Thread(runA, "A2");
            threadA2.start();

            Thread.sleep(500);

            Thread threadB1 = new Thread(runB, "B1");
            threadB1.start();

            Thread.sleep(1000);

            threadA1.interrupt();
            threadA2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
