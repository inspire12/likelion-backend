
package com.inspire12.likelionbackend.module.core.thread.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ThreadAsyncService {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

//    @Async
    public void getHello(){
        log.info("executing Thread Name .. [{}]", Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // 1초간 정지
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    @Async
    public String getHelloWaitResponse(){
        log.info("executing Thread Name .. [{}]", Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // 1초간 정지
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "hello";
    }
}
