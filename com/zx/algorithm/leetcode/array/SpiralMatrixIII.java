package com.zx.algorithm.leetcode.array;

/**
 * Created by zhangxin on 2022/01/26.
 * Time : 23:16
 * 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始
 *
 * 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 *
 * 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
 *
 * 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
 *
 * 最终，我们到过网格的所有R * C个空间。
 *
 * 按照访问顺序返回表示网格位置的坐标列表。
 */
public class SpiralMatrixIII {

    public static void main(String[] args) {
        int rows = 5, cols = 6, rStart = 1, cStart = 4;
        int[][] res = spiralMatrixIII(rows, cols, rStart, cStart);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }
    }

    // 步长step的取值是：1，1，2，2，3，3...
    private static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[] dX = new int[]{0, 1, 0, -1};
        int[] dY = new int[]{1, 0, -1, 0};
        int step = 0, cur = 0; // cur取值：右0，下1，左2，上3；cur为0或者2的时候 step++ 即只有向右或者向左走的时候 步长才会增加1
        int[][] res = new int[rows * cols][2];
        res[0][0] = rStart;
        res[0][1] = cStart;
        int count = 1;
        while (count < rows * cols) {
            if (cur == 0 || cur == 2) step++;
            for (int i = 0; i < step; i++) {
                rStart += dX[cur];
                cStart += dY[cur];
                // 例如：4*4的情况下(rows=4,cols=4,rStart=1,cStart=2)，当rStart=0，cStart=4时，则不会记录到res中；
                // 此时，cur=1(向下走)，step保持不变(step=3)，rStart++直到rStart=3，在此期间都不会记录到res中；
                // 此时，cur=2(向左走)，step++(step=4)，cStart--直到cStart=0，在此期间只有cStart<4的时候，才会记录到res中；
                // 按照这个流程循环下去直到count=rows * cols，程序退出。
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    res[count][0] = rStart;
                    res[count][1] = cStart;
                    count++;
                }
            }
            cur = (cur + 1) % 4;
        }
        return res;
    }
}
