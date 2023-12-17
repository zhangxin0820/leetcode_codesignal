package com.zx.algorithm.leetcode.array;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = dailyTemperatures(temperatures);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        for (int i = length - 1; i > 0 ; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (temperatures[i] > temperatures[j]) {
                    answer[j] = i - j;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}
