package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxin on 2022/01/14.
 * Time : 23:34
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinations {

    private static final List<String> nums = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        if (digits == null || "".equals(digits)) return result;
        dfs(digits, 0, result, tmp);
        return result;
    }

    private static void dfs(String digits, int num, List<String> result, StringBuilder tmp) {
        if (num == digits.length()) {
            result.add(new String(tmp));
            return;
        }
        String str = nums.get(digits.charAt(num) - '0');
        for (int i = 0; i < str.length(); i++) {
            tmp.append(str.charAt(i));
            dfs(digits, num + 1, result, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
