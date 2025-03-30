package com.inspire12.likelionbackend.module.core.ioc.config;

import com.inspire12.likelionbackend.module.core.ioc.service.CustomSimpleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanRegisterConfig {

    @Bean
    public CustomSimpleService customService() {
        return new CustomSimpleService();
    }
}
