package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxin on 2021/12/05.
 * Time : 17:21
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 去重：如果i > start && candidates[i] == candidates[i-1]，直接跳过这次循环，保证同样的元素在tmp中的同一个位置只被选择一次，这里有点难理解。
 * 举个例子，例如原数组经过排序为[1,1,2,5],target为8，如果不这样做，两个1都会被选择放在第一个位置，然后进递归，这样就会有两个[1,2,5]被加入结果集，导致重复。
 */
public class CombinationSum2 {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum.combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        ArrayList<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
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
            if (target - candidates[i] < 0) break;
            if (i > start && candidates[i] == candidates[i-1]) continue;
            tmp.add(candidates[i]);
            dfs(candidates, target-candidates[i], n, i+1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
