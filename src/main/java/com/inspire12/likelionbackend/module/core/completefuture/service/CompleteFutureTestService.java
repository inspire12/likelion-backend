package com.inspire12.likelionbackend.module.core.completefuture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class CompleteFutureTestService {
    private final Executor customFutureThreadPoolExecutor;
    private Logger log = LoggerFactory.getLogger(CompleteFutureTestService.class);

    public CompleteFutureTestService(Executor customFutureThreadPoolExecutor) {
        this.customFutureThreadPoolExecutor = customFutureThreadPoolExecutor;
    }

    public void sayHello(int i) {
        CompletableFuture.supplyAsync(() -> {
                    log.info("executing Thread Name .. [{}]", Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000); // 1초간 정지
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Hello " + i;
                })
                .thenApply(s -> s.concat("영학"))
                .thenAccept(log::info);
    }

    public String getHelloSync() {
        log.info("executing Thread Name .. [{}]", Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // 1초간 정지
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello";
    }

    public CompletableFuture<String> getHello(int i) {
        return CompletableFuture.supplyAsync(() -> {
                    log.info("executing Thread Name .. [{}]", Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000); // 1초간 정지
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Hello " + i;
                })
                .thenApply(s -> s.concat("영학"));
    }

    public CompletableFuture<String> getHelloWithThreadPool() {

        return CompletableFuture.supplyAsync(() -> {
            log.info("executing Thread Name .. [{}]", Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // 1초간 정지
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        }, customFutureThreadPoolExecutor);
    }

}
