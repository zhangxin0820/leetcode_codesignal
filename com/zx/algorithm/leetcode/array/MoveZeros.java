package com.zx.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Created by zhangxin on 2021/12/03.
 * Time : 21:52
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeros {

    public static void main(String[] args) {
        moveZeros(new int[]{1,1,0,3,12});
        moveZeros_2(new int[]{1,1,0,3,12});
    }

    private static void moveZeros(int[] nums) {
        int n = nums.length, left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static void moveZeros_2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (nums[index] == 0) continue;
                index = i;
            } else {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index++] = tmp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
