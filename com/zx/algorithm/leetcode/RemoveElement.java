package com.zx.algorithm.leetcode;

/**
 * Created by zhangxin on 2022/01/03.
 * Time : 19:35
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 3, 4, 0, 2};
        System.out.println(removeElement(nums, 2));
    }

    private static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
