package com.zx.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxin on 2021/12/02.
 * Time : 10:51
 * 全排列第二种实现
 */
public class Permutations_2 {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Permutations_2 permutations = new Permutations_2();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        dfs(new ArrayList<>(), nums);
        return res;
    }

    private void dfs(List<Integer> tmp, int[] nums) {
        int n = nums.length;
        if (tmp.size() == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (tmp.contains(nums[i])) continue;
            tmp.add(nums[i]);
            dfs(tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
