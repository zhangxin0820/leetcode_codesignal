package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumIslands_BFS {

    private static boolean[][] visited;
    private static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + move[i][0];
                int nextY = curY + move[i][1];
                if (nextX < 0 || nextY < 0 || nextX == grid.length || nextY == grid[0].length) continue;
                if (!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true; // 只要加入队列就要立即标记访问 不要在使用的时候再标记访问 会有问题
                }
            }
        }
    }
}
