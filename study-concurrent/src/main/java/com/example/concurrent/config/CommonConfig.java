package com.example.concurrent.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangwj.
 * @date 2021/8/12
 */

@Configuration
@Slf4j
public class CommonConfig {
    @Bean
    ScheduledExecutorService scheduledExecutorService() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        executor.setKeepAliveTime(10L, TimeUnit.MINUTES);
        executor.allowCoreThreadTimeOut(true);
        return executor;
    }
}
