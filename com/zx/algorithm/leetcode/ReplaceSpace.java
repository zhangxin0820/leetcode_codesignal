package com.zx.algorithm.leetcode;

/**
 * Created by zhangxin on 2022/01/03.
 * Time : 21:51
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are h";
        System.out.println(replaceSpace_1(s));
        System.out.println(replaceSpace_2(s));
    }

    private static String replaceSpace_1(String s) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String replaceSpace_2(String s) {
        if (s == null) return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') sb.append("  ");
        }
        if (sb.length() == 0) return s;

        int left = s.length() - 1;
        s += sb.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
}
