package com.inspire12.likelionbackend.module.core.ioc.service;

import com.inspire12.likelionbackend.module.core.ioc.config.BeanComponentScanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanShowService {

    public void showBean() {
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(CustomSimpleService.class);
//
//        // 빈 조회하기
//        CustomSimpleService myService = context.getBean(CustomSimpleService.class);
//        myService.sayName();

        // ApplicationContext (스프링 컨테이너) 생성
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanComponentScanConfig.class);

        CustomAnnotationService myService = context.getBean(CustomAnnotationService.class);
        myService.sayName();
    }
}
