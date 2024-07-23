package com.zx.algorithm.leetcode.dynamic;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())"));
    }

    //dp[i]表示以第i个字符结尾的最长有效括号的长度
    //比如说()(())中，dp[4]=2,dp[5]=6  dp[5]=dp[4]+2+dp[1]=2+2+2=6
    //状态转移方程：
    //对于当前位为 ) 的情况：
    //1.如果前一位是 ( 且i-2<0,   dp[i] = 2
    //2.如果前一位是 ( 且i-2>=0 ，dp[i] = dp[i-2] + 2
    //3.如果前一位是 ) 且ch[i-1-dp[i-1]]=='(' （说明对称的位置正好是左括号）
    //有两种情况，如果对称的位置之前没有非零dp值(i-1-dp[i-1]<1)，dp[i]=dp[i-1] + 2
    //如果对称的位置之前有非零dp值(i-1-dp[i-1]>=1)，dp[i]=dp[i-1] + 2 + dp[i-2-dp[i-1]]
    //4.如果前一位是 ) 但是对称位也是 ) ，dp[i] = 0;
    public static int longestValidParentheses(String s) {

        int maxLength = 0;
        if (s == null || s.isEmpty()) return maxLength;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i >= 1 && s.charAt(i - 1) == '(') {
                    if (i - 2 < 0) dp[i] = 2;
                    else dp[i] = dp[i - 2] + 2;
                } else if (i >= 1 && i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1) == ')') {
                    if (s.charAt(i - 1 - dp[i - 1]) == '(') {
                        if (i - 2 - dp[i - 1] >= 0) dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]];
                        else dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
