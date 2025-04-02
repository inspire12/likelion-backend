package com.inspire12.likelionbackend.module.core.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class LogExecutionTimeAspect {
    private static final Logger log = LoggerFactory.getLogger("LogExecutionTimeAspect");

    @Around("@annotation(com.inspire12.likelionbackend.module.core.aop.aspect.LogExecutionTime)")
    public Object logExecutionTime
            (ProceedingJoinPoint joinPoint) throws Throwable {
        /*TODO
        * Aspect 내에 어디에 본 함수를 실행할까? joinPoint.proceed() 위치 찾기
        * */
        /* 여기는 함수의 시그니처에 맞춰서 작성해야한다 */
        String username = joinPoint.getArgs()[0].toString();
//        String email = joinPoint.getArgs()[1].toString();
        log.info("사용자 등록 시작 - username: {}", username);
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("사용자 등록 완료 - username: {} {}", username, endTime - startTime);
        return result;
    }
}
