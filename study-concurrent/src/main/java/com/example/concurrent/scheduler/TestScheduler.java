package com.example.concurrent.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.awt.windows.ThemeReader;

/**
 * @author huangwj.
 * @date 2021/8/12
 */
@Slf4j
@Component
public class TestScheduler {

    @Scheduled(cron = "*/2 * * * * ?")
    public void test1() throws InterruptedException {
        String str = Thread.currentThread().getName() + " --> test1: ";
        for (int i = 0; i < 100; i++) {
            log.info(str + i);
//            Thread.sleep(10);
        }
    }

    @Scheduled(cron = "*/2 * * * * ?")
    public void test2() throws InterruptedException {
        String str = Thread.currentThread().getName() + "--> test2: ";
        for (int i = 0; i < 100; i++) {
            log.info(str + i);
//            Thread.sleep(10);
        }
    }
}
