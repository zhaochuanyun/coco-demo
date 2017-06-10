package com.coco.demo.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类使用到了一个接口InvocationHandler和一个代理类Proxy ，这两个类配合使用实现了动态代理的功能。 那么什么是动态代理呢？ 我们平常说的代理类是指：
 * 给每个具体类写一个代理类，以后要使用某个具体类时，只要创建它的代理类的对象，然后调用代理类的方法就可以了。
 * 可是如果现在有许多的具体类，那就需要有许多的代理类才可以，这样很显然不合适。所以动态代理就应运而生了，我们只要写一个类实现 InvocationHandler
 * 并实现它的invoke方法，然后再用Proxy的工厂方法newProxyInstance（）创建一个代理对象，这个对象同样可以实现对具体类的代理功能。
 * 而且想代理哪个具体类，只要给Handler（以下代码中的Invoker）的构造器传入这个具体对象的实例就可以了。感觉是不是自己为该具体类造了一个代理类呢？呵呵~
 * 
 * @See http://weixiaolu.iteye.com/blog/1477774
 */

// 接口类
interface AbstractShow {

    public void show();

}

// 具体类
class Show implements AbstractShow {

    @Override
    public void show() {
        System.out.println("我是A类！");
    }

}

// 动态代理类，实现InvocationHandler接口
class Invoker implements InvocationHandler {
    AbstractShow as;

    public Invoker(AbstractShow as) {
        this.as = as;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {
        // 调用之前可以做一些处理
        method.invoke(as, arg);
        // 调用之后也可以做一些处理
        return null;
    }
}

/**
 * 测试类
 */
class DynamicProxyTest {

    public static void main(String[] args) {
        // 创建具体类ClassB的处理对象
        Invoker invoker = new Invoker(new Show());
        // 获得具体类ClassA的代理
        AbstractShow as = (AbstractShow) Proxy.newProxyInstance(
                AbstractShow.class.getClassLoader(), new Class[] { AbstractShow.class }, invoker);
        // 调用Show的show方法。
        as.show();
    }

}
