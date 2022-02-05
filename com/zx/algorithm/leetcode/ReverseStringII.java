package com.zx.algorithm.leetcode;

/**
 * Created by zhangxin on 2022/02/04.
 * Time : 18:04
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseStringII {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    private static String reverseStr(String s, int k) {
        int len = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            int right = Math.min(i + k, len) - 1;
            reverse(arr, i, right);
        }
        return new String(arr);
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
