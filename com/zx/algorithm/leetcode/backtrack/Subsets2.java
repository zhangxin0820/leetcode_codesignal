package com.zx.algorithm.leetcode.backtrack;

import java.util.*;

/**
 * Created by zhangxin on 2022/02/08.
 * Time : 21:08
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class Subsets2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, 0, result, deque);
        return result;
    }

    private static void dfs(int[] nums, int startIndex, List<List<Integer>> result, Deque<Integer> deque) {
        result.add(new ArrayList<>(deque));
        for (int i = startIndex; i < nums.length; i++) {
            // 跳过当前树层使用过的、相同的元素
            if (i > startIndex && nums[i-1] == nums[i]) continue;
            deque.addLast(nums[i]);
            dfs(nums, i + 1, result, deque);
            deque.removeLast();
        }
    }
}
