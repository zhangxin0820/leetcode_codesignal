package com.zx.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by zhangxin on 2022/01/23.
 * Time : 17:59
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = new int[]{4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    private static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int i = res.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[i--] = nums[left] * nums[left];
                left++;
            } else {
                res[i--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
