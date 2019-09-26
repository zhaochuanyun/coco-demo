package com.coco.demo.spi;

import java.util.ServiceLoader;

/**
 * https://juejin.im/post/5b9b1c115188255c5e66d18c
 * https://juejin.im/post/5af952fdf265da0b9e652de3
 * https://juejin.im/post/5acee93b51882555731c82ba
 * https://juejin.im/post/5ca2317d6fb9a05e605e3090
 */
public class SPIMain {

    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}
