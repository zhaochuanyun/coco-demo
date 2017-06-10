package com.coco.demo.concurrency.lock;

/**
 * synchronized关键字作用
 * 
 * @see http://www.cnblogs.com/devinzhang/archive/2011/12/14/2287675.html
 * @author zhaochuanyun379
 *
 */
public class Foo extends Thread {

    private String name;
    private String val;

    public Foo(String name, String v) {
        this.name = name;
        val = v;
    }

    public void printVal() {
        synchronized (this) {
            while (true)
                System.out.println(name + val);
        }
    }

    public void run() {
        printVal();
    }

    public static void main(String args[]) {
        Foo f1 = new Foo("Foo 1:", "printVal");
        f1.start();
        Foo f2 = new Foo("Foo 2:", "printVal");
        f2.start();
    }

}