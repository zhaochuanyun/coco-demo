package com.coco.spring.advisor;

import org.springframework.aop.support.IntroductionInfoSupport;

import com.coco.spring.introduce.Monitorable;

public class MyIntroduceInfo extends IntroductionInfoSupport {
    public MyIntroduceInfo() {
        super();
        super.publishedInterfaces.add(Monitorable.class);
    }
}
