package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxin on 2021/12/02.
 * Time : 10:05
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 */
public class Combinations {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combine(4, 2);
        System.out.println(combinations.res);
    }

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(1, n, k, tmp);
        return res;
    }

    public void dfs(int start, int n, int k, ArrayList<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            dfs(i + 1, n, k, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
