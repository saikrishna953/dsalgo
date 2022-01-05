package com.dsalgo;

//https://leetcode.com/problems/single-element-in-a-sorted-array/
public class AppearsOnceInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        //int result = findSingleElementInSortedArrayBrute(arr);
        int result = findSingleElementInSortedArrayEfficient(arr);
        System.out.println("Result-" + result);
    }

    private static int findSingleElementInSortedArrayEfficient(int[] arr) {

        int low = 0;
        //-2 because last element can be the required element
        int high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) >> 1;
            //even number xor 1 is next even number, 2->4
            //odd number xor 1 is previous number, 3->2
            if (arr[mid] == arr[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[low];
    }

    private static int findSingleElementInSortedArrayBrute(int[] arr) {

        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }
}
