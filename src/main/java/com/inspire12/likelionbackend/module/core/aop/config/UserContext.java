package com.inspire12.likelionbackend.module.core.aop.config;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserContext {
}