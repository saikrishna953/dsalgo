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

    //brute force
    private static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        // Iterate through all elements of ar2[] starting from
        // the last element
        for (int i=n-1; i>=0; i--)
        {
            /* Find the smallest element greater than ar2[i]. Move all
               elements one position ahead till the smallest greater
               element is not found */
            int j, last = arr1[m-1];
            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];

            // If there was a greater element
            if (j != m-2 || last > arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
