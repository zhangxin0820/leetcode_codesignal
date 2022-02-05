package com.zx.algorithm.leetcode.backtrack;

/**
 * Created bj zhangiin on 2022/02/04.
 * Time : 21:17
 * 给你两个m * n的二进制矩阵grid1 和grid2，它们只包含0（表示水域）和 1（表示陆地）。一个 岛屿是由 四个方向（水平或者竖直）上相邻的1组成的区域。任何矩阵以外的区域都视为水域。
 * 如果 grid2的一个岛屿，被 grid1的一个岛屿完全 包含，也就是说 grid2中该岛屿的每一个格子都被 grid1中同一个岛屿完全包含，那么我们称 grid2中的这个岛屿为 子岛屿。
 * 请你返回 grid2 中 子岛屿 的 数目 。
 */
public class CountSubIslands {

    static int count = 0;
    public static void main(String[] args) {
        int[][] grid1 = new int[][]{
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };

        int[][] grid2 = new int[][]{
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

        System.out.println(countSubIslands(grid1, grid2));
    }

    // 尽管我们知道了当对应grid1中的元素不为1，也不能立即返回，这是因为我们需要遍历完整个部分，使得将遍历过的岛屿的值1不再设置为1。
    private static int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    count = 1;
                    dfs(grid1, grid2, i, j);
                    res += count;
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] != 1) return;
        grid2[i][j] = -1;
        if (grid1[i][j] != 1) count = 0;
        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i, j + 1);
        dfs(grid1, grid2, i, j - 1);
    }
}
