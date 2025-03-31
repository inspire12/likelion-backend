package com.inspire12.likelionbackend.module.core.ioc.controller;

import com.inspire12.likelionbackend.module.core.ioc.service.BeanShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ioc")
@RestController
public class BeanShowController {
    private final BeanShowService beanShowService;

    public BeanShowController() {
        this.beanShowService = new BeanShowService();
    }

    @GetMapping
    public void show() {
        beanShowService.showBean();
    }
}
