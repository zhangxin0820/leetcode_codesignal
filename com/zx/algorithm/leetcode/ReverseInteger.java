package com.zx.algorithm.leetcode;

/**
 * Created by zhangxin on 2022/02/05.
 * Time : 12:51
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int x = 1234567;
        System.out.println(reverse(x));
        System.out.println(reverse_2(x));
    }

    private static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 根据数学推导 Integer.MIN_VALUE/10 <= res <= Integer.MAX_VALUE/10
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) return 0;
            int tmp = x % 10;
            x = x / 10;
            res = res * 10 + tmp;
        }
        return res;
    }

    private static int reverse_2(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            // 开始判断上一轮循环之后 已经反转过的数字大小
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10))
                return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < Integer.MIN_VALUE % 10))
                return 0;
            x = x / 10;
            res = res * 10 + tmp;
        }
        return res;
    }
}
