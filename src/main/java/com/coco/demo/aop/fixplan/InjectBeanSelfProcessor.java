package com.coco.demo.aop.fixplan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InjectBeanSelfProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanSelfAware) {
            System.out.println("inject proxy：" + bean.getClass());
            BeanSelfAware myBean = (BeanSelfAware) bean;
            myBean.setSelf(bean);
            return myBean;
        }
        return bean;
    }

}
