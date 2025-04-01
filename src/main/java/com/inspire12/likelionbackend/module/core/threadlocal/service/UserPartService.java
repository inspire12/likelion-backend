package com.inspire12.likelionbackend.module.core.threadlocal.service;

import org.springframework.stereotype.Service;

@Service
public class UserPartService {
    private final UserPartPartService userPartPartService;

    public UserPartService(UserPartPartService userPartPartService) {
        this.userPartPartService = userPartPartService;
    }

    public void notUseCurrentUsername() {
        userPartPartService.useCurrentUsername();
    }
}
