package com.zx.algorithm.other;

/**
 * @author zhangxin82@jd.com
 * @create 2019/12/2 9:47 上午
 * @description
 */

public class ThreeThreadPrint {

    private int count = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    public static void main(String[] args) {

        ThreeThreadPrint demo = new ThreeThreadPrint();
        demo.print();
    }

    public void print() {
        Thread t1 = new Thread(new MutiThreadRunner(lock2, lock1, "线程1: "));
        Thread t2 = new Thread(new MutiThreadRunner(lock3, lock2, "线程2: "));
        Thread t3 = new Thread(new MutiThreadRunner(lock1, lock3, "线程3: "));
        t1.start();
        t2.start();
        t3.start();
    }

    class MutiThreadRunner implements Runnable {

        private final Object nextLock;
        private final Object currentLock;
        private final String content;

        public MutiThreadRunner(Object nextLock, Object currentLock, String content) {
            this.nextLock = nextLock;
            this.currentLock = currentLock;
            this.content = content;
        }

        @Override



        public void run() {
            while (count <= 10) {
                synchronized (nextLock) {
                    synchronized (currentLock) {
                        System.out.println(content + count++);
                        // 唤醒等待当前锁的线程
                        currentLock.notifyAll();
                    }
                    try {
                        // 如果还需要继续执行，则让出下一个线程对应的锁并进入等待状态
                        if (count <= 10) {
                            nextLock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
