package com.zx.algorithm.leetcode.dynamic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxin on 2022/01/14.
 * Time : 22:00
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreak_2(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (!dp[i]) continue;
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[len];
    }

    // 完全背包问题；s是背包，word是物品；单词能否组成字符串s，就是问物品能不能把背包装满
    // dp[i]:字符串长度为i的话，dp[i]为true，表示前i个字符可以拆分为一个或多个在字典中出现的单词
    // 如果确定dp[j]是true，且[j, i]这个区间的子串出现在字典里，那么dp[i]一定是true。(j<i)
    private static boolean wordBreak_2(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
