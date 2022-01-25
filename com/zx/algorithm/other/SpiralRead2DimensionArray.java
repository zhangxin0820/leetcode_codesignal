package com.zx.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxin on 2022/01/24.
 * Time : 17:47
 * 螺旋遍历二维数组
 */
public class SpiralRead2DimensionArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        while (left <= right && top <= bottom) {
            // 1. 从(top, left) -> (top, right)
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // 2. 从(top + 1, right) -> (bottom, right)
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // if为应对只有一行的情况
            if (left < right && top < bottom) {
                // 3. 从(bottom, right - 1) -> (bottom, left + 1)
                for (int i = right - 1; i >= left + 1; i--) {
                    result.add(matrix[bottom][i]);
                }
                // 4. 从(bottom, left) -> (top - 1, left)
                for (int i = bottom; i >= top + 1; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left ++;
            top ++;
            right --;
            bottom --;
        }
        return result;
    }
}
