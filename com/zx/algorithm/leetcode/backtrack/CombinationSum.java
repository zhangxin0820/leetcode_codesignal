package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxin on 2021/12/05.
 * Time : 09:04
 * 给定一个无重复元素的正整数数组candidates和一个正整数target,找出candidates中所有可以使数字和为目标数target的唯一组合.
 * 排序才能使用剪枝的原因：乱序的时候，target - candidates[i] < 0，但是下一层可能会出现target - candidates[i+1] > 0情况。
 */
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum.combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(candidates, target, n, 0, tmp);
        return res;
    }

    private void dfs(int[] candidates, int target, int n, int start, ArrayList<Integer> tmp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < n; i++) {
            if (target - candidates[i] < 0) break; // 这里是剪枝 前提是必须要从小到大排序数组
            tmp.add(candidates[i]);
            dfs(candidates, target-candidates[i], n, i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
