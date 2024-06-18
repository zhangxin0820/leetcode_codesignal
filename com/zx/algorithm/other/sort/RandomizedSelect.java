package com.zx.algorithm.other.sort;

import java.util.Random;

/**
 * 找到第k小(大)的数
 */

public class RandomizedSelect {

    public static void main(String[] args) {

    }

    /**
     *
     * @param a 数组
     * @param p 数组的第一个元素
     * @param r 数组的最后一个元素
     * @param i 需要求第几小的元素
     * @return
     */
    public static int randomizedSelect(int[] a,int p,int r,int i) {
        if (p == r) {
            return a[p];//这种情况就是数组内只有一个元素
        }
        int q = randomizedPartition(a, p, r);
        int k = q - p + 1; //拿到上一句中作为枢纽的数是第几小的数
        if (k == i) {
            return a[q];
        } else if (i < k) {
            return randomizedSelect(a, p, q - 1, i);
        } else {
            return randomizedSelect(a, q + 1, r, i - k);
        }
    }

    private static int randomizedPartition(int[] a,int p,int r) {
        Random random = new Random();
        int q = random.nextInt() % (r - p + 1) + p;
        swap(a, r, q);
        return partition(a, p, r);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int slow = left, fast = left;
        while (fast < right) {
            if (arr[fast] < pivot) {
                swap(arr, fast, slow);
                slow++;
            }
            fast++;
        }
        swap(arr, right, slow);

        return slow;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
