package com.zx.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxin on 2022/02/04.
 * Time : 18:17
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) return result; // 算是剪枝了
        int pointNum = 0;
        dfs(s, 0, pointNum, result);
        return result;
    }

    private static void dfs(String s, int startIndex, int pointNum, List<String> result) {
        if (pointNum == 3) {
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
                return;
            }
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1); // 在str的后⾯插⼊⼀个逗点
                pointNum++;
                dfs(s, i + 2, pointNum, result); // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2); // 回溯删掉逗点
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private static boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        // 0开头的数字 并且不是只有一个0 不合法
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' && s.charAt(i) < '0') return false;
            num = num * 10 + (s.charAt(i) - '0');
            // 如果已经大于255了 不合法
            if (num > 255) return false;
        }
        return true;
    }
}
