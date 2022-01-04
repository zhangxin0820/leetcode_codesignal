package com.zx.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by zhangxin on 2022/01/03.
 * Time : 19:40
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    private static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
