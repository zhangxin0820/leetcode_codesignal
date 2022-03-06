package com.zx.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Created by zhangxin on 2022/02/26.
 * Time : 18:52
 * 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    // 顺序计算每个数左边数组的乘积，然后逆序计算每个数右边数组的乘积，然后再相乘。
    private static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            tmp *= (i == 0 ? 1 : nums[i - 1]);
            result[i] = tmp;
        }
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp *= (i == nums.length - 1 ? 1 : nums[i + 1]);
            result[i] *= tmp;
        }
        return result;
    }
}
