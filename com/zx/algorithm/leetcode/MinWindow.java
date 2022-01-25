package com.zx.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxin on 2022/01/24.
 * Time : 09:40
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinWindow {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = 0, slow = 0, len = Integer.MAX_VALUE;
        for (int fast = 0; fast < s.length(); fast++) {
            mapS.put(s.charAt(fast), mapS.getOrDefault(s.charAt(fast), 0) + 1);
            if (mapT.containsKey(s.charAt(fast)) && mapS.get(s.charAt(fast)) <= mapT.get(s.charAt(fast))) count++;
            // slow<fast : 如果t中没有该字符或者t中该字符的数目小于已经遍历的s中该字符的数目 则缩小窗口的范围 即slow++
            while (slow < fast && (!mapT.containsKey(s.charAt(slow)) || mapS.get(s.charAt(slow)) > mapT.get(s.charAt(slow)))) {
                int cnt = mapS.get(s.charAt(slow)) - 1;
                mapS.put(s.charAt(slow), cnt);
                slow++;
            }
            if (count == t.length() && fast - slow + 1 < len) {
                len = fast - slow + 1;
                result = s.substring(slow, fast + 1);
            }
        }
        return result;
    }
}
