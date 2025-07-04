package com.newone.xiaohongshu.auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池
 *
 * @author liuwh
 * @date 2025/06/30 18:08:29
 */
@Configuration
@Slf4j
public class ThreadPoolConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数
        threadPoolTaskExecutor.setCorePoolSize(10);
        // 最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(50);
        // 阻塞队列大小
        threadPoolTaskExecutor.setQueueCapacity(200);
        // 线程活跃时间（秒）
        threadPoolTaskExecutor.setKeepAliveSeconds(30);
        // 线程前缀名
        threadPoolTaskExecutor.setThreadNamePrefix("AuthExecutor-");
        // 拒绝策略：由调用线程处理（一般为主线程）
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 等待所有任务结束后再关闭线程池
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置等待时间，如果超过这个时间还没销毁就强制销毁，以确保应用最后能够被关闭，而不是被没有完成的任务阻塞
        threadPoolTaskExecutor.setAwaitTerminationSeconds(60);

        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

}
