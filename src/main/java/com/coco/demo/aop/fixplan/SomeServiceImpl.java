package com.coco.demo.aop.fixplan;

public class SomeServiceImpl implements SomeService, BeanSelfAware

{

    private SomeService self;// AOP增强后的代理对象

    // 实现BeanSelfAware接口

    public void setSelf(Object proxyBean)

    {

        this.self = (SomeService) proxyBean;

    }

    public void someMethod()

    {

        self.someInnerMethod();// 注意这句，通过self这个对象，而不是直接调用的

        // foo...

    }

    public void someInnerMethod()

    {

        // bar...

    }

}
