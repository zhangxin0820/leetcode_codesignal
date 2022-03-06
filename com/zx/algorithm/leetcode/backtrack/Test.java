package com.zx.algorithm.leetcode.backtrack;

import java.util.*;

/**
 * Created by zhangxin on 2022/02/19.
 * Time : 20:36
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> rank = new ArrayList<>();
        rank.add(3);
        rank.add(1);
        rank.add(2);
        findTotalImbalance(rank);
    }

    public static long findTotalImbalance(List<Integer> rank) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> index = new LinkedList<>();
        dfs(rank, 0, result, deque, index);
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            Collections.sort(list);
            if (list.size() <= 1) continue;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) - list.get(j-1) > 1) sum++;
            }
        }
        return sum;
    }

    private static void dfs(List<Integer> rank, int start, List<List<Integer>> result, Deque<Integer> deque, Deque<Integer> index) {
        if (deque.size() > 0) {
            result.add(new ArrayList<>(deque));
        }
        for (int i = start; i < rank.size(); i++) {
            if (!index.isEmpty() && i - index.getLast() > 1) continue;
            deque.add(rank.get(i));
            index.add(i);
            dfs(rank, i+1, result, deque, index);
            index.removeLast();
            deque.removeLast();
        }
    }
}
