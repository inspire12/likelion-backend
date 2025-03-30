package com.inspire12.likelionbackend.module.core.properties.controller;

import com.inspire12.likelionbackend.module.core.properties.service.EnvApplicationPlaygroundService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/env")
@RestController
public class EnvApplicationController {
    private final EnvApplicationPlaygroundService envApplicationPlaygroundService;

    public EnvApplicationController(EnvApplicationPlaygroundService envApplicationPlaygroundService) {
        this.envApplicationPlaygroundService = envApplicationPlaygroundService;
    }

    @GetMapping("/custom")
    public String geApplicationEnv() {
        return envApplicationPlaygroundService.getCustomValue();
    }

    @GetMapping("/port")
    public String geApplicationName() {
        return envApplicationPlaygroundService.getServerPort();
    }
}
