package com.zx.algorithm.leetcode.dynamic;

/**
 * @author zhangxin82@jd.com
 * @create 2018-12-19 17:35
 * @description 爬楼梯最少步数
 */

public class ClimbStairs {

    public int climbStairs(int n) {

        if (n <= 1) return 1;

        int result = 0;
        int oneStep = 1, twoStep = 1;

        for (int i = 2; i <= n; i++) {
            result = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = result;
        }

        return result;
    }

    public int climbStairs2(int n) {

        if (n <= 1) return 1;

        int[] dp = new int[n];
        dp[0] = 1; // 爬第一层方法
        dp[1] = 2; // 爬第二层方法

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
