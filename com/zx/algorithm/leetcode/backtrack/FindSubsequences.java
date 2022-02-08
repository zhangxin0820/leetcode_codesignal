package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangxin on 2022/02/08.
 * Time : 21:23
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */
public class FindSubsequences {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }

    private static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, result, path);
        return result;
    }

    private static void dfs(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> path) {
        if (path.size() >= 2) result.add(new ArrayList<>(path));
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && (nums[i] < path.get(path.size() - 1)) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            dfs(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }

    private static void dfs2(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> path) {
        if (path.size() >= 2) result.add(new ArrayList<>(path));
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && (nums[i] < path.get(path.size() - 1)) || used[nums[i] + 100] == 1) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            dfs(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}
