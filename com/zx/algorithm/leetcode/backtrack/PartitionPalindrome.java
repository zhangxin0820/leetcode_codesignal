package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangxin on 2022/01/14.
 * Time : 23:23
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 由于是在同一个字符串中不断截取，因此需要每次传入一个index，每次从index开始继续切割。
 */
public class PartitionPalindrome {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();
        dfs(s, 0, lists, deque);
        return lists;
    }

    private static void dfs(String s, int index, List<List<String>> lists, Deque<String> deque) {
        if (index == s.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (!isPalindrome(s, index, i)) continue;
            deque.addLast(s.substring(index, i + 1));
            dfs(s, i + 1, lists, deque);
            deque.removeLast();
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
