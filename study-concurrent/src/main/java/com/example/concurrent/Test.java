package com.example.concurrent;

import java.time.LocalDateTime;

/**
 * @author huangwj.
 * @date 2021/9/1
 */
public class Test {

    private static final LocalDateTime phase1 = LocalDateTime.of(2021, 9,1,0,0);

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        long minPremium = now.isAfter(phase1) ? 1000 : 500;
        System.out.println(minPremium);
    }
}
