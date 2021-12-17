package com.zx.algorithm.other;

import java.util.Arrays;

/**
 * Created by zhangxin on 2021/12/16.
 * Time : 09:39
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 8, 1, 9, 5, 4, 7};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pos = partition(array, start, end);
            quickSort(array, start, pos - 1);
            quickSort(array, pos + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int x = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] <= x) {
                i++;
                exchange(array, i, j);
            }
        }
        exchange(array, i + 1, end);
        return i + 1;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
