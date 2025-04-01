package com.inspire12.likelionbackend.module.core.thread.config;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//@EnableAsync
//@Configuration
public class ThreadPoolConfig {
    private static final int CORE_POOL_SIZE = 2;
//    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 2;
//    private static final int MAX_POOL_SIZE = 10;


//    @Bean(name = "customThreadPoolExecutor")
    public Executor customThreadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();

        // 기본적으로 유지되는 최소 스레드 개수 설정 (항상 유지)
        threadPoolExecutor.setCorePoolSize(CORE_POOL_SIZE);

        // thread-pool의 사용할 수 있는 최대 스레드 수를 설정할 수 있다. 기본값 Integer.MAX_VALUE
        threadPoolExecutor.setMaxPoolSize(MAX_POOL_SIZE);

        // ThreadPool에서 생성되는 스레드 이름의 접두사(prefix)
        // 로그 확인 시 어떤 ThreadPool의 스레드인지 쉽게 확인 가능함
        threadPoolExecutor.setThreadNamePrefix("likelion-");

        // 모든 스레드가 작업 중일 때, 작업을 대기시킬 수 있는 큐의 용량 설정
        threadPoolExecutor.setQueueCapacity(50);

        // 최대 스레드(maxPoolSize 초과)가 유휴 상태일 때 종료되기 전 대기 시간(초 단위)
        threadPoolExecutor.setKeepAliveSeconds(60);

        // 작업이 초과했을 때의 처리 정책 설정 (요청한 쪽의 스레드가 직접 작업을 실행)
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 설정된 threadPoolExecutor 초기화
        // 호출 필요 but SpringBoot 에선 Bean 등록시 initialize() 호출 해서 생략해도 됨
        threadPoolExecutor.initialize();
        return threadPoolExecutor;
    }
}
