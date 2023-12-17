package com.zx.algorithm.leetcode.array;

import java.util.ArrayDeque;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    public static void main(String[] args) {
//        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height = new int[]{4, 3, 2, 4, 2, 5};
        System.out.println(trap(height));
        System.out.println(trap1(height));
    }

    /**
     * 只有右边的高度比左边的高度高的时候 才会接住雨水
     * 使用单调栈 存储每个高度的 index 维护一个从栈底到栈顶 由高到低的过程（单调递减）
     * 当 height[i] 要比栈顶元素对应的高度小 则将 i 压进栈顶
     *
     * 当 height[i] 要比栈顶元素对应的高度大并且栈不为空的时候
     * 记录栈顶元素 prev 对应的高度 height[prev] 弹出栈顶元素 prev
     * 如果此时栈为空 则说明左边没有柱子了 无法接住雨水 直接结束循环
     * left 为当前最新栈顶元素 记录对应高度 height[left]
     * 此时 可接雨水对应的宽 width 为 i - left - 1
     * 此时 可接雨水对应的高 curHeight 为 Math.min(height[i], height[left]) - height[prev]
     * 当前可以接住雨水的体积为 width * curHeight
     * 结果 ans 进行累计求和即可得到结果
     *
     * @param height
     * @return
     */
    private static int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int ans = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int prev = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int width = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[prev];
                ans += width * curHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 动态规划
     * i 左边最高柱子和右边最高柱子取最小值 再减去自身高度 就是可以存储雨水的体积
     * 即 Math.min(leftMax[i], rightMax[i]) - height[i]
     * @param height
     * @return
     */
    private static int trap1(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int ans = 0;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}
