package com.zx.algorithm.other;

/**
 * Created by zhangxin on 2021/12/31.
 * Time : 20:00
 */
public class MultithreadPrintV2 extends Thread {

    private volatile static int state = 1;
    private int type;

    public static void main(String[] args) {
        new MultithreadPrintV2(0).start();
        new MultithreadPrintV2(1).start();
    }

    MultithreadPrintV2(int type) {
        this.type = type;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; ) {
            if (state % 2 == type) {
                System.out.println(state);
                state++;
                i++;
            }
        }
    }
}
