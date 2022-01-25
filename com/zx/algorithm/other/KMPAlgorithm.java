package com.zx.algorithm.other;

import java.util.Arrays;

/**
 * Created by zhangxin on 2022/01/22.
 * Time : 18:29
 * KMP算法
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        String text = "ABAABABCABAA";
        String pattern = "ABABCABAA";
        System.out.println(strStr(text, pattern));
    }

    private static int strStr(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        if (pattern.length() == 0) return 0;

        int[] next = getNext(pattern);
        int i = 0;
        int j = 0;
        char[] charsText = text.toCharArray();
        char[] charsPattern = pattern.toCharArray();
        while (i < charsText.length && j < charsPattern.length) {
            if (j == -1 || charsText[i] == charsPattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == charsPattern.length) {
            return i - j;
        }
        return -1;
    }

    private static int[] getNext(String pattern) {
        char[] charArr = pattern.toCharArray();
        int[] next = new int[charArr.length];
        next[0] = 0;
        int len = 0;
        int i = 1;
        while (i < charArr.length) {
            // 1.举例：比如这次进来的字符串是上面的AB,此时上一次的共有字符串长度是len=0(因为上一次就一个A字符，没有共有字符串，当然是0)，
            // 要想判断这次共有字符串长度会不会加1，只需要判断这次的字符串AB比上次字符串A多出来的字符(也就是B)是不是和上次共有字符串长度位置上的字符相等
            // 也就是charArr[1(i)] == charArr[0(len)]?，这里是不等，所以不能加1
            // 2.比如这次进来的是ABA，上一次是AB，那么多出来的这个A和上次AB的共有字符串长度位置(len=0)上的字符是否相等，显然charArr[0] == charArr[2]，所以len++;
            // 3.再比如：这次进来的是ABAB,上一次是ABA,上一次的共有字符串长度是len=1，判断这次多出来的字符B是不是和charArr[1]相等，显然相等，len++;
            //   简单说：对于ABA下一个进来的B，判断ABA共有前后缀长度上的字符是否和新来的字符相等(ABA中的B是不是等于新来的B)，相等len++，不等走else判断。
            if (charArr[i] == charArr[len]) {
                len++;
                next[i] = len;
                i++;
            } else {
                // 如果不相等，说明这次多出来的这个字符并没有让共有字符串的长度加1，而且，可能还会直接影响到上一次的共有字符串长度。

                // 需要说明：next[x] 定义为： P[0]~P[x] 这一段字符串，使得k-前缀恰等于k-后缀的最大的k.
                // 所以我们需要缩短len的长度，而且让len的长度尽可能大；例如ABABC，来了一个C，前两个AB为子串m，后两个AB为子串n，则ABAB的公共前缀在m中，公共后缀在n中；
                // 所以len的长度应该更改为：使得m的k-前缀等于n的k-后缀的最大的k；而且，m和n是相同的，其实就是求m的最长公共前后缀，即len = next[len-1]。

                // 此时charArr[0(len)]是A，还是和C不相同，说明这次的len还是不能作为判断，理论上还得去那更早一次的len值，但是这时候有个临界情况，因为已经拿到第一次进来的len了，
                // len拿不到更早一次的值了，或者说到这已经没有共有字符串了，说明这次加多出来的字符C。彻底让这个字符串ABABC没有了共有字符串，也就是len=0，可以放心的将这一轮字符串
                // 的共有字符串长度设为0了，这轮len值设置完毕，i++，进行下一轮设置
                if (len > 0) {
                    len = next[len - 1];
                } else {
                    next[i] = len;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(next));
        for (int j = next.length - 1; j > 0; j--) {
            next[j] = next[j - 1];
        }
        next[0] = -1;
        return next;
    }
}
