package com.zx.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxin on 2022/01/24.
 * Time : 11:47
 * 904. 水果成篮
 * 这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 * 要求：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 */
public class MinTotalFruit {

    public static void main(String[] args) {
        int[] fruits = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(fruits));
    }

    private static int totalFruit(int[] fruits) {
        Map<Integer,Integer> window = new HashMap<>();
        int slow = 0, max = 0;
        for (int fast = 0; fast < fruits.length; fast++){
            int fruit = fruits[fast];
            window.put(fruit, window.getOrDefault(fruit, 0) + 1);

            while (window.size() > 2) {
                int curFruit = fruits[slow++];
                if (window.containsKey(curFruit)) {
                    window.put(curFruit, window.get(curFruit) - 1);
                    if (window.get(curFruit) == 0) window.remove(curFruit);
                }
            }
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}
