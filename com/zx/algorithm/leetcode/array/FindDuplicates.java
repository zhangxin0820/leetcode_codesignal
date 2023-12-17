package com.zx.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复元素
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 */
public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    /**
     * 用一个 visited[] 来存储 nums 中的元素值-1来作为 index。
     * 当 nums[i] 被访问，则把 visited[nums[i]-1] 置为 -1。
     * 当访问 visited[nums[i]-1] 的时候 发现为 -1，则说明 nums[i] 这个值出现过，即为重复数字。
     * @param nums
     * @return
     */
    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        for (int num : nums) {
            if (visited[num - 1] == 0) {
                visited[num - 1] = -1;
            } else {
                result.add(num);
            }
        }
        return result;
    }
}
