package com.zx.algorithm.leetcode.dynamic;

/**
 * Created by zhangxin on 2021/12/26.
 * Time : 11:32
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    // j*(i-j)代表把i拆分为j和i-j两个数相乘
    // j*dp[i-j]代表把i拆分成j和继续把(i-j)这个数拆分，取(i-j)拆分结果中的最大乘积与j相乘
    private static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
