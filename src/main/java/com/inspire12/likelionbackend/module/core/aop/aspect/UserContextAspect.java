package com.inspire12.likelionbackend.module.core.aop.aspect;

import com.inspire12.likelionbackend.module.core.threadlocal.context.UserContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserContextAspect {
    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    // UserContext 어노테이션이 붙은 메서드 또는 클래스 대상
    @Pointcut("@annotation(com.inspire12.likelionbackend.module.core.aop.config.UserContext) || @within(com.inspire12.likelionbackend.module.core.aop.config.UserContext)")
    public void userContextTarget() {}

    @Around("userContextTarget()")
    public Object manageUserContext(ProceedingJoinPoint joinPoint) throws Throwable {
        String username = UserContextHolder.getAuthenticatedUsername();
        UserContextHolder.setUser(username);

        try {
            log.info("[UserContextAspect] 현재 사용자: {}", username);
            return joinPoint.proceed();  // 실제 메서드 호출
        } finally {
            UserContextHolder.clear(); // 반드시 제거 필요
        }
    }
}
