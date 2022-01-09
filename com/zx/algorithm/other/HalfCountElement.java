package com.zx.algorithm.other;

/**
 * Created by zhangxin on 2022/01/06.
 * Time : 10:07
 * 判断一个有序数组中 是否存在出现次数超过数组长度的一半的元素
 */
public class HalfCountElement {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2};
        System.out.println(halfCountElement(nums));
    }

    private static boolean halfCountElement(int[] nums) {
        if (nums == null) return false;
        int n = nums.length;
        if (n == 1) return true;
        if (n == 2) return nums[0] == nums[1];
        int val = nums[n / 2];
        int count = 1;
        int head = n / 2 - 1, tail = n / 2 + 1;
        while (head >= 0) {
            if (nums[head] == val) count++;
            head--;
        }
        while (tail < n) {
            if (nums[tail] == val) count++;
            tail++;
        }
        if (count > n/2) return true;
        return false;
    }
}
