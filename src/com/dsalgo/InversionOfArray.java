package com.dsalgo;

import java.util.Arrays;

public class InversionOfArray {

    public static void main(String[] args) {

        int[] input  = {8,4,2,1};

        int bruteCount = findNumberOfInversionsInBruteForce(input);

        System.out.println("Brute force count:" + bruteCount);

        int optimalCount = findNumberOfInversionsInOptimal(input);

        System.out.println("optimalCount:" + optimalCount);
    }

    private static int findNumberOfInversionsInOptimal(int[] input) {

        int n = input.length;
        int count = 0;
        if((input.length == 0) || (input.length == 1)){
            return count;
        }else{
            return mergeSortCount(input,0,n-1);
        }
    }

    private static int mergeSortCount(int[] input, int l, int h) {

        int count = 0;
        if(l<h){
            int m = (l+h)/2;
            count += mergeSortCount(input,l,m);

            count += mergeSortCount(input,m+1,h);
            count += mergeAndCount(input,l,m,h);
        }
        return count;

    }

    private static int mergeAndCount(int[] arr, int l,
                                     int m, int r)
    {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
             //How to get the number of inversions in merge()?
             //In merge process, let i is used for indexing left sub-array
             // and j for right sub-array. At any step in merge(), if a[i] is greater than a[j],
             // then there are (mid – i) inversions. because left and right subarrays are sorted,
             // so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater
                // than a[j]
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    private static int findNumberOfInversionsInBruteForce(int[] input) {

        int n = input.length;
        int count = 0;
        if((input.length == 0) || (input.length == 1)){
            return count;
        }else{
            for (int i = 0; i < n; i++) {

                for (int j = i+1; j < n; j++) {
                    if(input[i] > input[j]){
                        count++;
                    }
                }

            }
        }
        return count;
    }
}
