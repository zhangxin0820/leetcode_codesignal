package com.zx.algorithm.leetcode;

/**
 * @author zhangxin82@jd.com
 * @create 2019-04-09 11:32
 * @description 棋盘对角最短路径 给定MxN棋盘，只允许从左上往右下走，每次走一格。共有多少种走法？
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
