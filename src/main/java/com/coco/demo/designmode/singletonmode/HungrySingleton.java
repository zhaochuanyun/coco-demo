package com.coco.demo.designmode.singletonmode;

/**
 * 饿汉，单例模式
 * 
 * @see http://cantellow.iteye.com/blog/838473
 * @author zhaochuanyun
 *
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
