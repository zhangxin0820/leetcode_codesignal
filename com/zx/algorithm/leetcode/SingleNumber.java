package com.zx.algorithm.leetcode;

/**
 * @author zhangxin82@jd.com
 * @create 2019/11/6 10:30 上午
 * @description 寻找只出现一次的数字 其他数字均出现了k次
 */

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr= {2,2,2,5,2,3,4,5,4,5,4,5,4};
        System.out.println(singleNumber(arr, 4));
    }

    public static int singleNumber(int[] nums, int k) {
        int len = nums.length;
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < len; j++) {
                count[i] += ((nums[j] >> i) & 1);
            }
            count[i] = count[i] % k;
            result |= (count[i] << i);
        }
        return result;
    }
}
