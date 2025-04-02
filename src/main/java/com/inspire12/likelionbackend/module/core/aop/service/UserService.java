package com.inspire12.likelionbackend.module.core.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class.getName());

    public void registerUser(String username, String email) {
        // 로깅
        logStartExecutionTime(username);
        validateUserInput(username, email);
        long start = System.currentTimeMillis();
        // 핵심 로직
        registerCoreUser(username, email);
        // 로깅
        long end = System.currentTimeMillis();

        logEndExecutionTime(username, end - start);
    }

    public void registerCoreUser(String username, String email) {
        log.info("DB에 사용자 저장 로직 실행");
    }

    private void logStartExecutionTime(String username) {
        // TODO registerUser 에서 로깅을 담당하는 파트를 담는다
        log.info("사용자 등록 시작 - username: {}", username);
    }

    private void logEndExecutionTime(String username, long executionTime) {
        // TODO registerUser 에서 로깅을 담당하는 파트를 담는다
        log.info("사용자 등록 완료 - username: {} 걸린 시간: {}", username, executionTime);

    }
    private void validateUserInput(String username, String email) {
        // TODO registerUser 에서 유저 입력 유효성 체크를 담당하는 파트를 담는다
        // 유효성 검사
        if (username == null || email == null) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        // 이메일 검증
        if (!email.endsWith("@example.com")) {
            throw new SecurityException("허용되지 않은 이메일 도메인입니다.");
        }
    }

}
