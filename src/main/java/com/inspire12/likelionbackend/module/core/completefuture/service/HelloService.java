package com.inspire12.likelionbackend.module.core.completefuture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class HelloService {
    private final CompleteFutureTestService completeFutureTestService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public HelloService(CompleteFutureTestService completeFutureTestService) {
        this.completeFutureTestService = completeFutureTestService;
    }

    // 사용법 1) 바로 실행
    public void sayHello() {
        for (int i = 0; i < 10; i++) {
            completeFutureTestService.sayHello(i);
        }
    }

    // 동기적으로 처리
    public void getGroupHelloSync() {
        log.info("executing Async Thread Name .. [{}]", Thread.currentThread().getName());
        List<String> helloReturns = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String hello = completeFutureTestService.getHelloSync();
            log.info(hello);
        }
    }

    // 사용법 2) return 결과값을 가져와서 작업
    public void getGroupHello() {
        log.info("executing Async Thread Name .. [{}]", Thread.currentThread().getName());
        List<CompletableFuture<String>> helloReturns = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CompletableFuture<String> hello = completeFutureTestService.getHello(i);
            String helloMessage = hello.join();
            log.info(helloMessage);
        }
    }

    public void getGroupHelloWitThreadPool() {
        log.info("executing Async Thread Name .. [{}]", Thread.currentThread().getName());
        List<CompletableFuture<String>> helloReturns = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<String> hello = completeFutureTestService.getHelloWithThreadPool();
            helloReturns.add(hello);
        }
        for (CompletableFuture<String> hello : helloReturns) {
            String helloMessage = hello.join();
            log.info(helloMessage);
        }
    }
}
