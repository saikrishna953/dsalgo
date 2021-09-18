package com.dsalgo;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("Sai");
        int[] arr = {4, 3, 4, 2, 5};
        //2nd problem
        int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
        int arr2[] = new int[]{2, 3, 8, 13};
        merge(arr1,arr2);
        System.out.print("After Merging nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));

    }

    private static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        for (int i=0; i<m; i++)
        {
            int curr = arr1[i];
            if(arr1[i] > arr2[0] ){
                int arr20 = arr2[0];
                arr2[0] = curr;
                arr1[i] = arr20;
                Arrays.sort(arr2);
            }

        }
    }
}
