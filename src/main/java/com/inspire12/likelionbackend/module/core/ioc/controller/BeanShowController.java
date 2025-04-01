package com.inspire12.likelionbackend.module.core.ioc.controller;

import com.inspire12.likelionbackend.module.core.ioc.service.BeanShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ioc")
@RestController
public class BeanShowController {
    private final BeanShowService beanShowService = new BeanShowService();
//
//    public BeanShowController(BeanShowService beanShowService) {
//        this.beanShowService = beanShowService;
//    }

    @GetMapping
    public void show() {
        beanShowService.showBean();
    }
}
