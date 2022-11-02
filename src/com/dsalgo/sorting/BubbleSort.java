package com.dsalgo.sorting;

import java.util.Arrays;

//tc-O(n^2)
//sc-O(1)
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr ={2,5,3,8,1};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort(int[] arr) {

        boolean swapped;
        for (int i = 0; i < arr.length; i++) {

            swapped = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

}
