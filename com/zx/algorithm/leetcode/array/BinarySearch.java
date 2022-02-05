package com.zx.algorithm.leetcode.array;

/**
 * Created by zhangxin on 2022/02/05.
 * Time : 13:04
 */
public class BinarySearch {

    public static void main(String[] args) {

    }

    // 左闭右闭区间 [left, right]
    private static int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;
        int left = 0, right = nums.length - 1;
        // 当left==right，区间[left, right]依然有效，所以用 <=
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1; // target 在左区间，所以[left, middle - 1]
            else if (nums[mid] > target) right = mid - 1; // target 在右区间，所以[middle + 1, right]
        }
        return -1;
    }
}
