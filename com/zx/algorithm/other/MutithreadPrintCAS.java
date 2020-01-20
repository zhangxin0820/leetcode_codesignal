package com.zx.algorithm.other;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangxin82@jd.com
 * @create 2019/11/14 9:41 上午
 * @description t1打印偶数 t2打印奇数
 */

public class MutithreadPrintCAS {

    static AtomicInteger num = new AtomicInteger(0);
    static volatile boolean flag = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for ( ;num.get() < 10; ) {
                if (!flag && (num.get() == 0 || num.incrementAndGet() % 2 == 0)) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    System.out.println("t1 :: " + num.get());
                    flag = true;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for ( ;num.get() < 10; ) {
                if (flag && num.incrementAndGet() % 2 != 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    System.out.println("t2 :: " + num.get());
                    flag = false;
                }
            }
        });

        t1.start();
        t2.start();
    }
}
