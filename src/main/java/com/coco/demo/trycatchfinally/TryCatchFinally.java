package com.coco.demo.trycatchfinally;

import org.apache.activemq.openwire.tool.CGeneratorTask;

public class TryCatchFinally {

    static int get1() {
        int a = 0;
        try {
            a = 1;
            return a;
        } finally {
            a = 2;
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(get1());
    }

}
