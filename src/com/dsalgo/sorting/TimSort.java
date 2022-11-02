package com.dsalgo.sorting;

import java.util.Arrays;

//tc-O(n)-best case
//sc-O(n)
public class TimSort {

    private static final Integer MIN_RUN_SIZE = 4;

    public static void main(String[] args) {
        int[] arr = {-2, 7, 15, -14, 0, 15, 0, 7, -7, -4, -13, 5, 8, -14, 12};
        Arrays.stream(arr).forEach(w -> System.out.print(w + ","));
        System.out.println();
        sort(arr);
    }

    private static void sort(int[] arr) {

        int start;
        for (start = 0; start < arr.length; start += MIN_RUN_SIZE) {
            int end = Math.min(start + MIN_RUN_SIZE, arr.length - 1);
            new InsertionSort().sortWithInRange(arr, start, end);
        }

        for (int runSize = MIN_RUN_SIZE; runSize < arr.length; runSize *= 2) {
            for (start = 0; start < arr.length; start += 2 * runSize) {

                int mid = start + runSize - 1;
                int end = Math.min(start + 2 * runSize - 1, arr.length - 1);
                if (mid < end) {
                    MergeSort.merge(arr, start, mid, end);
                }

            }
        }

        Arrays.stream(arr).forEach(w -> System.out.print(w + ","));

    }

}
