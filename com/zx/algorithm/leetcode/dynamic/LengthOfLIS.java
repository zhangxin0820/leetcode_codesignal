package com.zx.algorithm.leetcode.dynamic;

import java.util.Arrays;

/**
 * Created by zhangxin on 2022/01/22.
 * Time : 20:59
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums));
    }

    // dp[i]表示i之前包括i的最长上升子序列的长度。
    // 位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。
    // 所以：if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);
    // 注意这里不是要dp[i] 与 dp[j] + 1进行比较，而是我们要取dp[j] + 1的最大值。
    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(dp[i], result);
            }
        }
        return result;
    }
}
