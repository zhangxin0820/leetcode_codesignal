package com.zx.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * Created by zhangxin on 2021/12/03.
 * Time : 21:52
 */
public class MoveZeros {

    public static void main(String[] args) {
        moveZeros(new int[]{1,1,0,3,12});
        moveZeros_2(new int[]{1,1,0,3,12});
    }

    private static void moveZeros(int[] nums) {
        int tmp;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            tmp = nums[i];
            nums[i] = 0;
            nums[index++] = tmp;
        }
        System.out.println(Arrays.toString(nums));
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
