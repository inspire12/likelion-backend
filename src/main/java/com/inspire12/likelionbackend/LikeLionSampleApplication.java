package com.inspire12.likelionbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LikeLionSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LikeLionSampleApplication.class, args);
//        ConfigurableApplicationContext ctx = SpringApplication.run(LikeLionSampleApplication.class, args);
//
//        log.info("===== 등록된 모든 빈 출력 =====");
//
//        // 등록된 빈 이름을 가져와 정렬 후 출력
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            log.info(beanName);
//        }
    }
}
