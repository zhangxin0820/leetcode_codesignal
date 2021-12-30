package com.zx.algorithm.other.dynamic;

/**
 * Created by zhangxin on 2021/12/24.
 * Time : 15:14
 * 01背包问题
 */
public class Bag01 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        int max = weightBag_2(weight, value, bagSize);
        System.out.println(max);
    }

    // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
    private static int weightBag(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize + 1];
        for (int j = 1; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) { // 遍历物品
            for (int j = 0; j <= bagSize; j++) { // 遍历背包容量
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[weight.length - 1][bagSize];
    }

    private static int weightBag_2(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int j = 0; j <= bagSize; j++) {
            System.out.print(dp[j] + " ");
        }
        System.out.println();

        return dp[bagSize];
    }
}
