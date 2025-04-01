package com.inspire12.likelionbackend.module.core.aop.service;

import com.inspire12.likelionbackend.module.core.aop.aspect.LogExecutionTime;
import com.inspire12.likelionbackend.module.core.aop.aspect.UserInputValidate;
import com.inspire12.likelionbackend.module.core.aop.config.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class.getName());

    @LogExecutionTime
    @UserInputValidate
    public void registerUser(String username, String email) { // 변경됨
        log.info("DB에 사용자 저장 로직 실행");
    }

    private void logStartExecutionTime(String username) {
        log.info("사용자 등록 시작 - username: {}", username);
    }

    private void logEndExecutionTime(String username, long executionTime) {
        log.info("사용자 등록 완료 - username: {} {}", username, executionTime);
    }
    private void validateUserInput(String username, String email) {
        // 유효성 검사
        if (username == null || email == null) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        // 이메일 검증
        if (!email.endsWith("@example.com")) {
            throw new SecurityException("허용되지 않은 이메일 도메인입니다.");
        }
    }

    @UserContext
    public void geUser(Long userId) { // 변경됨
        log.info("get user id: {}", userId);

    }
}
