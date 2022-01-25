package com.zx.algorithm.other;

import java.util.Arrays;

/**
 * Created by zhangxin on 2022/01/24.
 * Time : 18:19
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static int[][] generateMatrix(int n) {
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1, count = n * n;
        while (num <= count) {
            // 1. left -> right遍历top层
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            // 2. top -> bottom遍历right层
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            // 3. right -> left遍历bottom层
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            // 4. bottom -> top遍历left层
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}
