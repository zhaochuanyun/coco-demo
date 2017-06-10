package com.coco.demo.designmode.singletonmode;

/**
 * 双重加锁单例模式
 * 
 * @author zhaochuanyun
 * 
 * @see http://ifeve.com/easy-happens-before/
 * @see http://www.iteye.com/topic/260515
 * @see http://marlonyao.iteye.com/blog/875420#comments
 *
 */
public class DCLSingleton {

    // volatile关键字确保变量被实例化时多个线程能正确的处理变量
    private volatile static DCLSingleton instance;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                // 注意这里的双重校验
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

}
