package com.zx.algorithm.other.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangxin on 2021/12/16.
 * Time : 21:01
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int maxLength = lengthOfLongestSubstring_2("arabcacfr");
        System.out.println(maxLength);
    }

    // 每次计算的都是以当前字符为结尾的最长子串长度
    private static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) return 0;
        int curLength = 0; // 记录以当前字符的上一个字符为结尾的最长不重复子字符串
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int distance = i - map.get(s.charAt(i)); // 当前字符与上一次出现位置的距离
                if (distance > curLength) {
                    curLength++;
                } else {
                    curLength = distance;
                }
            } else {
                curLength++;
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            map.put(s.charAt(i), i);
        }

        return maxLength;
    }

    // 双指针
    private static int lengthOfLongestSubstring_2(String s) {
        if ("".equals(s)) return 0;
        Set<Character> set =new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                res = Math.max(res, i - j);
            } else {
                set.remove(s.charAt(j++)); //当遇到j指向的字符放不进去 就删掉前面的字符并且j++ 直到指向的字符能放进去
            }
        }
        return res;
    }
}
