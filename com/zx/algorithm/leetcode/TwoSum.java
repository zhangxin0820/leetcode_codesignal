package com.zx.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxin82@jd.com
 * @create 2018-12-19 16:28
 * @description
 */

public class TwoSum {

    public int[] towSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int element = target - nums[i];
            if (map.containsKey(element) && map.get(element) != i) {
                return new int[]{i, map.get(element)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
