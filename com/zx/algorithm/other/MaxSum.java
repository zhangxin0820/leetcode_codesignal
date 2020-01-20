package com.zx.algorithm.other;

/**
 * @author zhangxin82@jd.com
 * @create 2019/12/2 10:33 上午
 * @description
 */

public class MaxSum {

    public static void main(String[] args) {

        int[] data = new int[]{-1, -2, -3, -4, -5};
        System.out.println(maxSum(data));
    }

    public static int maxSum(int[] data) {

        int num = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            num += data[i];
            if (num > sum) {
                sum = num;
            }
            if (num < 0) {
                num = 0;
            }
        }
        return sum;
    }
}
