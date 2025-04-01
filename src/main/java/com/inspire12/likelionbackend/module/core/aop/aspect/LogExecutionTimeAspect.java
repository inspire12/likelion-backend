package com.inspire12.likelionbackend.module.core.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogExecutionTimeAspect {
    private static final Logger log = LoggerFactory.getLogger("LogExecutionTimeAspect");
    @Around("@annotation(com.inspire12.likelionbackend.module.core.aop.aspect.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        /*TODO
        * Aspect 내에 어디에 본 함수를 실행할까? joinPoint.proceed()
        * */
        /* 여기는 함수의 시그니처에 맞춰서 작성해야한다 */
        Object[] args = joinPoint.getArgs();
        String username = (args.length > 0 && args[0] instanceof String) ?  (String) args[0]: "unknown";
        log.info("사용자 등록 시작 - username: {}", username);
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("사용자 등록 완료 - username: {} {}", username, endTime - startTime);
        return proceed;
    }
}
