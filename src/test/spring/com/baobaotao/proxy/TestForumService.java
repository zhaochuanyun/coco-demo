package com.baobaotao.proxy;

import java.lang.reflect.Proxy;

public class TestForumService {
    public static void main(String[] args) {
        // 业务类正常编码的测试
        // ForumService forumService = new ForumServiceImpl();
        // forumService.removeTopic(1012);

        // 使用JDK动态代理
//         ForumService target = new ForumServiceImpl();
//         PerformaceHandler handler = new PerformaceHandler(target);
//         ForumService proxy = (ForumService) Proxy.newProxyInstance(target
//         .getClass().getClassLoader(),
//         target.getClass().getInterfaces(), handler);
//         proxy.removeTopic(1012);

        // 使用CGLib动态代理
        CglibProxy proxy = new CglibProxy();
        ForumService forumService = (ForumService) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeTopic(1023);

    }
}
