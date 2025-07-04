package com.newone.xiaohongshu.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootTest
@Slf4j
public class ThreadPoolTaskExecutorTests {

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    void testSubmit() {
        threadPoolTaskExecutor.execute(() -> {
            try {
                Thread.sleep(1000);
                int i = 1/0;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("异步线程中....");
        });
    }

}
