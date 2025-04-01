package com.inspire12.likelionbackend.module.core.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
    private static final Logger log = LoggerFactory.getLogger("PerformanceAspect");

//     성능 측정할 메서드 정의 (특정 패키지 내 모든 메서드)
//    @Pointcut("execution(* com.inspire12..*(..)))
    @Pointcut("@annotation(com.inspire12.likelionbackend.module.core.aop.config.PerformanceCheck) || @within(com.inspire12.likelionbackend.module.core.aop.config.PerformanceCheck)")
    public void performanceTarget() {
    }

    @Around("performanceTarget()")
    public Object measurePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        // 시작 시간 측정
        long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed();  // 실제 메서드 호출
        } finally {
            long end = System.currentTimeMillis();
            log.info("[Performance] {}  executed in {} ms"
                    , joinPoint.getSignature().toShortString(), (end - start));
        }
    }
}
