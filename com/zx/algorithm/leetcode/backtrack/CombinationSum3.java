package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangxin on 2022/01/17.
 * Time : 09:26
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 1.所有数字都是正整数。2.解集不能包含重复的组合。
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3, 9);
        System.out.println(result);
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> tmp = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(k, n, 1, 0, result, tmp);
        return result;
    }

    // 剪枝优化：
    // 1.已经选择的元素个数：path.size();
    // 2.还需要的元素个数为: k - path.size();
    // 3.在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
    private static void dfs(int k, int target, int index, int sum, List<List<Integer>> result, LinkedList<Integer> tmp) {
        if (sum > target) return;
        if (tmp.size() == k) {
            if (target == sum) result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i <= 9 - (k - tmp.size()) + 1; i++) {
            tmp.add(i);
            sum += i;
            dfs(k, target, i + 1, sum, result, tmp);
            tmp.removeLast();
            sum -= i;
        }
    }
}
