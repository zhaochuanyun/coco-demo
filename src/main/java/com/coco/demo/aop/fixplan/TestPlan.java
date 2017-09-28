package com.coco.demo.aop.fixplan;

/**
 * https://my.oschina.net/stephenzhang/blog/664593 http://fyting.iteye.com/blog/109236
 * http://www.iteye.com/topic/1122740
 */
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestPlan {

    public static void main(String[] args) {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        InjectBeanSelfProcessor postProcessor = new InjectBeanSelfProcessor();
        beanFactory.addBeanPostProcessor(postProcessor);

        // 从beanFactory取得AOP代理后的对象
        SomeService someServiceProxy = (SomeService) beanFactory.getBean("someService");

        // 在someMethod里面调用self的someInnerMethod，这样就正确了
        someServiceProxy.someMethod();
    }

}
