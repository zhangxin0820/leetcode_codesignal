package com.zx.algorithm.other.sort;

import java.util.Arrays;

public class QuickSortNew {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 8, 1, 9, 5, 4, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
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
