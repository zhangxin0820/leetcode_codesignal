package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangxin on 2022/02/08.
 * Time : 20:51
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        dfs(nums, 0, result, deque);
        return result;
    }

    private static void dfs(int[] nums, int startIndex, List<List<Integer>> result, Deque<Integer> deque) {
        result.add(new ArrayList<>(deque));
        for (int i = startIndex; i < nums.length; i++) {
            deque.addLast(nums[i]);
            dfs(nums, i + 1, result, deque);
            deque.removeLast();
        }
    }
}
