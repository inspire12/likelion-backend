package com.inspire12.likelionbackend.module.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/health")
@RestController
public class HealthController {

    private Logger log = LoggerFactory.getLogger(HealthController.class);

    @GetMapping
    public String health() {

        return "OK";
    }

    @GetMapping("/os")
    public String os() {
        String osName = System.getProperty("os.name");
        log.info("운영체제 이름: " + osName);
        // TODO API 호출로 docker 컨테이너 내에선 바뀐거 확인
        return "Don't touch me";
    }
}
