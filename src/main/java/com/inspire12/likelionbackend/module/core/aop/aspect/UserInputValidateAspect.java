package com.inspire12.likelionbackend.module.core.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserInputValidateAspect {
//    private static final Logger log = LoggerFactory.getLogger("UserInputValidateAspect");

    @Pointcut("@annotation(com.inspire12.likelionbackend.module.core.aop.aspect.UserInputValidate)")
    public void userInputValidatePointcut() {}

    @Around("userInputValidatePointcut()")
    public Object userInputValidate(ProceedingJoinPoint joinPoint) throws Throwable {
        /* TODO username, email 두 input 값을 확인하는 코드를 넣어주세요 */
        Object[] args = joinPoint.getArgs();
        String username = args[0].toString();
        String email = args[1].toString();

        if (username == null || email == null) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        // 이메일 검증
        if (!email.endsWith("@example.com")) {
            throw new SecurityException("허용되지 않은 이메일 도메인입니다.");
        }


        return joinPoint.proceed();
    }
}