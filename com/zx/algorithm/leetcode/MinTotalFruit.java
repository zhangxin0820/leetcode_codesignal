package com.zx.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxin on 2022/01/24.
 * Time : 11:47
 * 这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 */
public class MinTotalFruit {

    public static void main(String[] args) {
        int[] fruits = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(fruits));
    }

    private static int totalFruit(int[] fruits) {
        Map<Integer, Integer> window = new HashMap<>();
        int slow = 0, max = 0;
        for (int fast = 0; fast < fruits.length; fast++) {
            int fruit = fruits[fast];
            if (window.size() <= 2) {
                window.put(fruit, window.getOrDefault(fruit, 0) + 1);
            }
            while (window.size() > 2) {
                int tmp = fruits[slow++];
                if (window.containsKey(tmp)) {
                    window.put(tmp, window.get(tmp) - 1);
                    if (window.get(tmp) <= 0) {
                        window.remove(tmp);
                    }
                }
            }
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}
