package com.zx.algorithm.codesignal;

/**
 * @author zhangxin82@jd.com
 * @create 2019-04-09 11:24
 * @description 反转括号内字符串
 */

public class ReverseInParentheses {

    public String reverseInParentheses(String inputString) {

        StringBuilder sb = new StringBuilder(inputString);
        int start = 0, end = 0;
        while (sb.lastIndexOf("(") != -1) {
            start = sb.lastIndexOf("(");
            end = sb.indexOf(")", start);
            sb.replace(start, end + 1, new StringBuilder(sb.substring(start + 1, end)).reverse().toString());
        }
        return sb.toString();
    }
}
