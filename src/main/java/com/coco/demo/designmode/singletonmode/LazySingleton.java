package com.coco.demo.designmode.singletonmode;

/**
 * 懒汉，线程安全的单例模式
 * 
 * @author zhaochuanyun
 *
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
