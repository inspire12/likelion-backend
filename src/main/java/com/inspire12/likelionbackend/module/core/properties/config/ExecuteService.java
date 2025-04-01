package com.inspire12.likelionbackend.module.core.properties.config;

@FunctionalInterface
public interface ExecuteService<T> {
    T execute();
}
