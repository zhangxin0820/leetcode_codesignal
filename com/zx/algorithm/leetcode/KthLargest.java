package com.zx.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * Created by zhangxin on 2021/12/26.
 * Time : 15:32
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 */
public class KthLargest {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 15, 20};
        KthLargest kthLargest = new KthLargest(3, array);
        System.out.println(kthLargest.add(22));
    }

    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] array) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int i : array) {
            add(i);
        }
    }

    public int add(int n) {
        if (queue.size() < k) {
            queue.offer(n);
        } else {
            if (queue.peek() < n) {
                queue.poll();
                queue.offer(n);
            }
        }
        return queue.peek();
    }
}
