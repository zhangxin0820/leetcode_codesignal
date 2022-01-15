package com.zx.algorithm.other.sort;

import java.util.Arrays;

/**
 * Created by zhangxin on 2022/01/11.
 * Time : 16:48
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 8, 1, 9, 5, 4, 7};
        heapSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] arr, int size) {
        buildHeap(arr, size);
        for (int i = size - 1; i > 0; i--) {
            swap(arr, i, 0);
            maxHeapify(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, size);
        }
    }

    private static void maxHeapify(int[] arr, int i, int size) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, largest, size);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
