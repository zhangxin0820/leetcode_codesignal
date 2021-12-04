package com.zx.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by zhangxin on 2021/12/03.
 * Time : 21:52
 */
public class MoveZeros {

    public static void main(String[] args) {
        new MoveZeros().moveZeros(new int[]{0,1,0,3,12});
    }

    public void moveZeros(int[] nums) {
        int tmp;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            tmp = nums[i];
            if (index < 0) {
                index = 0;
            }
            nums[i] = 0;
            nums[index++] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
