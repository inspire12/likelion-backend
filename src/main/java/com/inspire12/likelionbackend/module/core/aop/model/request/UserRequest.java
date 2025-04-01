package com.inspire12.likelionbackend.module.core.aop.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String email;
}
