package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxin82@jd.com
 * @create 2019-05-07 16:06
 * @description 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */

public class Permutations_1_1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new Permutations_1_1().permute(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int cur) {

        if (cur == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            res.add(tmp);
        } else {
            for (int i = cur; i < nums.length; i++) {
                swap(nums, cur, i);
                dfs(res, nums, cur + 1);
                swap(nums, cur, i);
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
