package com.inspire12.likelionbackend.module.core.threadlocal.controller;

import com.inspire12.likelionbackend.module.core.threadlocal.context.UserContextHolder;
import com.inspire12.likelionbackend.module.core.threadlocal.service.UserThreadLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/threadlocal")
@RestController
public class ThreadLocalUserControllor {

    private final UserThreadLocalService userThreadLocalService;

    private final Logger log = LoggerFactory.getLogger(ThreadLocalUserControllor.class);

    public ThreadLocalUserControllor(UserThreadLocalService userThreadLocalService) {
        this.userThreadLocalService = userThreadLocalService;
    }

    @GetMapping("/users")
    public void users() {
        log.info(UserContextHolder.getUser());
    }

    // TODO 시작점
    @GetMapping("/username")
    public void usersThreadlocal(@RequestHeader("X-USER-NAME") String username) {
        userThreadLocalService.getCurrentUsername();
    }

}


