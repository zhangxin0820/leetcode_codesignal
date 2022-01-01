package com.zx.algorithm.other;

/**
 * @author zhangxin82@jd.com
 * @create 2019/11/5 7:18 下午
 * @description 多个线程交替打印0到100数字
 */

public class MultithreadPrint {

    private int count = 0;
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        MultithreadPrint demo = new MultithreadPrint();

        Runnable runnable = () -> {
            while (demo.count <= 10) {
                synchronized (demo.lock) {
                    System.out.println(Thread.currentThread().getName() + ": " + demo.count++);
                    demo.lock.notifyAll();
                    try {
                        if (demo.count <= 10) {
                            demo.lock.wait();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(runnable, "偶数").start();
        Thread.sleep(100);
        new Thread(runnable, "奇数").start();
    }
}
