package com.inspire12.likelionbackend.module.core.threadlocal.service;

import org.springframework.stereotype.Service;

@Service
public class UserThreadLocalService {
    private final UserPartService userPartService;

    public UserThreadLocalService(UserPartService userPartService) {
        this.userPartService = userPartService;
    }

    public void getCurrentUsername() {
        userPartService.notUseCurrentUsername();
    }
}
