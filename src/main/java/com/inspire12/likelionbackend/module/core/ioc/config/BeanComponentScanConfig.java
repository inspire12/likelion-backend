package com.inspire12.likelionbackend.module.core.ioc.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.inspire12.likelionbackend.module.core.ioc.*") //@Component가 붙은 클래스를 찾아 자동으로 빈을 등록해줌
//@Configuration
public class BeanComponentScanConfig {
}
