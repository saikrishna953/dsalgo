package com.dsalgo.sorting;

import java.util.Arrays;

//tc-O(nlogn)
//sc-O(n)
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 8, 1};
        sort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr, int l, int h) {

        if (l < h) {
            int m = l + (h - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, h);

            merge(arr, l, m, h);
        }

    }

    public static void merge(int[] arr, int l, int m, int h) {

        int n1 = m - l + 1;
        int n2 = h - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        int k = l;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                k++;
            } else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while (i < n1) {
            arr[k] = L[i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[k] = R[j];
            k++;
            j++;
        }
    }

}
