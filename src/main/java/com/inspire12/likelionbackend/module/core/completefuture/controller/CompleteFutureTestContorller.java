package com.inspire12.likelionbackend.module.core.completefuture.controller;

import com.inspire12.likelionbackend.module.core.completefuture.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/future")
@RestController
public class CompleteFutureTestContorller {
    private final HelloService helloService;

    public CompleteFutureTestContorller(HelloService helloService) {

        this.helloService = helloService;
    }

    @GetMapping("/hello/say")
    public void sayHello() {
        helloService.sayHello();
    }

    @GetMapping("/hello/group")
    public void hello() {
        helloService.getGroupHello();
    }
}
