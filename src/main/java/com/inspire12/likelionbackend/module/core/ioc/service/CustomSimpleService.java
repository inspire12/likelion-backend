package com.inspire12.likelionbackend.module.core.ioc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSimpleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sayName() {
        logger.info(this.getClass().getName());
    }
}
