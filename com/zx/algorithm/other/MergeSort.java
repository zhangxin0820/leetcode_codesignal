package com.zx.algorithm.other;

import java.util.Arrays;

/**
 * Created by zhangxin on 2021/12/14.
 * Time : 15:03
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 8, 1, 9, 5, 4, 7};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, end, mid);
        }
    }

    private static void merge(int[] array, int start, int end, int mid) {

        int[] arr = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                arr[k++] = array[i++];
            } else {
                arr[k++] = array[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = array[i++];
        }
        while (j <= end) {
            arr[k++] = array[j++];
        }

        for (int l = 0; l < arr.length; l++) {
            array[l + start] = arr[l];
        }
    }
}
