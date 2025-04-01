package com.inspire12.likelionbackend.module.core.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @GetMapping
    public String index() {
        log.info("index view");
        return "index";
    }
}
