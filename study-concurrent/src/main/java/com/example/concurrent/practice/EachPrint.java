package com.example.concurrent.practice;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 使用两个线程, 一个线程打印 1234....52
 * 另一个线程打印 ABCD....Z
 * 控制台输出A12B34C56D78....Z5152
 *
 * @author huangwj.
 * @date 2023/8/24
 */
public class EachPrint {

    @Test
    public void testEachPrint() {
        AtomicBoolean isA = new AtomicBoolean(true);

        new Thread(() -> {
            for (int i = 1; i < 53; ) {
                while (!isA.get()) {
                    System.out.print(i);
                    if (i % 2 == 0) {
                        isA.set(true);
                    }
                    i++;
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 65; i < 91; ) {
                while (isA.get()) {
                    System.out.print((char) i);
                    i++;
                    isA.set(false);
                }
            }
        }).start();
    }
}
