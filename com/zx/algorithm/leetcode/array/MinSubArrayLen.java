package com.zx.algorithm.leetcode.array;

/**
 * Created by zhangxin on 2022/01/23.
 * Time : 18:21
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int slow = 0, sum = 0, res = Integer.MAX_VALUE;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= target) {
                res = Math.min(res, fast - slow + 1);
                sum -= nums[slow++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
