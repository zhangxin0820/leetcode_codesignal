package com.zx.algorithm.leetcode;

import java.util.Arrays;

/**
 * Created by zhangxin on 2021/12/24.
 * Time : 13:31
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class FindContentChildren {

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 7, 10};
        int[] s = new int[]{1, 3, 5, 9};
        System.out.println(findContentChildren(g, s));
        System.out.println(findContentChildren_2(g, s));
    }

    // 思路1：优先考虑饼干，小饼干先喂饱小胃口
    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0, count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }

    // 思路2：优先考虑胃口，先喂饱大胃口
    private static int findContentChildren_2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = s.length - 1, count = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (start >= 0 && g[i] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }
}
