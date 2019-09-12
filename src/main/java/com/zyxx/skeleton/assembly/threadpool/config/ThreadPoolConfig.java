package com.zyxx.skeleton.assembly.threadpool.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author Tellsea
 * @date 2019/9/12
 * 参考文章：https://blog.csdn.net/u010687392/article/details/49850803
 */
@Slf4j
@Configuration
public class ThreadPoolConfig {

    @Bean
    public Executor defaultThreadPool() {
        log.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数量
        threadPoolTaskExecutor.setCorePoolSize(2);
        // 最大线程数量
        threadPoolTaskExecutor.setMaxPoolSize(5);
        // 队列中最大任务数
        threadPoolTaskExecutor.setQueueCapacity(2);
        // 线程名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("ThreadPool-");
        // 当达到最大线程数时如何处理新任务
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线程空闲后最大存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(60);
        // 初始化线程池
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}