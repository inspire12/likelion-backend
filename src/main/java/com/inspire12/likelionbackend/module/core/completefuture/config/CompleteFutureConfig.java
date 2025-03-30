package com.inspire12.likelionbackend.module.core.completefuture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
//@EnableAsync
public class CompleteFutureConfig {
    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 10;

    @Bean(name = "customFutureThreadPoolExecutor")
    public Executor customFutureThreadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();

        threadPoolExecutor.setCorePoolSize(CORE_POOL_SIZE);

        threadPoolExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        threadPoolExecutor.setThreadNamePrefix("likelion-future-");

        threadPoolExecutor.setQueueCapacity(50);

        threadPoolExecutor.setKeepAliveSeconds(60);
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        threadPoolExecutor.initialize();
        return threadPoolExecutor;
    }
}
