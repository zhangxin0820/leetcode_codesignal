package com.zx.algorithm.leetcode;

/**
 * Created by zhangxin on 2021/12/24.
 * Time : 13:53
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class WiggleMaxLength {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength(nums));
    }

    private static int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        int curDiff = 0, preDiff = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
