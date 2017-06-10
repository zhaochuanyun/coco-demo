package com.coco.demo.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @see http://www.cnblogs.com/stono/p/4394524.html
 * @author zhaochuanyun379
 *
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhance = new Enhancer();

    public Object getProxy(Class<?> clazz) {
        // 设置创建子类的类
        enhance.setSuperclass(clazz);
        enhance.setCallback(this);
        return enhance.create();
    }

    /**
     * 拦截所有目标类方法的调用<br>
     * obj 目标类的实例<br>
     * m 目标方法的反射对象 <br>
     * args 方法的参数 <br>
     * proxy 代理类的实例
     */
    @Override
    public Object intercept(Object obj, Method m, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before .....");
        // 代理类调用父类的方法
        Object invokeSuper = proxy.invokeSuper(obj, args);
        System.out.println("after ......");
        return invokeSuper;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.move();
    }

}

/**
 * 被代理的类
 * 
 */
class Train {

    public void move() {
        System.out.println("train is running!");
    }
}
