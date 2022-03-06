package com.zx.algorithm.other.backtrack;

/**
 * Created by zhangxin on 2022/02/23.
 * Time : 16:37
 */
public class FindHeaviestPackage {

    public static void main(String[] args) {
        int[] num = {4, 5, 20, 1, 8, 9};
        System.out.println(cal(num, num.length - 1));
    }

    private static int cal(int[] num, int tail) {
        if (tail == -1) {
            return 0;
        } else {
            if (tail == 0) {
                return num[0];
            } else {
                int max = num[tail];
                int lastIndex = tail;
                while (lastIndex > 0 && max > num[lastIndex - 1]) {
                    max += num[lastIndex - 1];
                    lastIndex--;
                    num[lastIndex] = max;
                }
                max = Math.max(max, cal(num, lastIndex - 1));
                return max;
            }
        }
    }
}
