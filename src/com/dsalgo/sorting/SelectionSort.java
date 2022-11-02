package com.dsalgo.sorting;

import java.util.Arrays;

//tc-O(n^2)
//sc-O(1)
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr ={2,5,3,8,1};
        stableSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min_ind = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min_ind]){
                    min_ind=j;
                }

                int temp = arr[min_ind];
                arr[min_ind] = arr[i];
                arr[i] = temp;
            }
        }
    }

    private static void stableSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min_ind = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min_ind]){
                    min_ind=j;
                }

                int key = arr[min_ind];
                while(min_ind > i){
                    arr[min_ind] = arr[min_ind-1];
                    min_ind--;
                }
                arr[i] = key;
            }
        }
    }
}
