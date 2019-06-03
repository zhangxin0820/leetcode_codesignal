package com.zx.algorithm.leetcode;

/**
 * @author zhangxin82@jd.com
 * @create 2019-04-09 11:29
 * @description 爬楼梯最小花费
 */

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int oneCost = 0, twoCost = 0;
        for (int num : cost) {
            int res = Math.min(oneCost, twoCost) + num;
            twoCost = oneCost;
            oneCost = res;
        }

        return Math.min(oneCost, twoCost);
    }

    public int minCostClimbingStairs2(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n];
        dp[0] = cost[0]; // 爬第一层
        dp[1] = cost[1]; // 爬第二层

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
