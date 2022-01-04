package com.zx.algorithm.leetcode;

/**
 * Created by zhangxin on 2022/01/04.
 * Time : 21:22
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "  the     sky is blue";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseWord(sb);
        return sb.toString();
    }

    private static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++; // 去掉头部空格
        while (s.charAt(end) == ' ') end--; // 去掉尾部空格
        StringBuilder sb = new StringBuilder();
        // 去掉中间部分的空格
        while (start <= end) {
            char c = s.charAt(start);
            // c不是空格则append
            // c是空格 但是sb最后一个字符不是空格 则append
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') sb.append(c);
            start++;
        }
        return sb;
    }

    private static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }

    private static void reverseWord(StringBuilder sb) {
        int start = 0;
        int end = start + 1;
        int len = sb.length();
        while (start < len) {
            while (end < len && sb.charAt(end) != ' ') end++;
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
