package com.dsalgo;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
//tc-log(min(m,n))
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 9, 11};
        int[] arr2 = {7, 12, 14, 15};
        double result = findMedian(arr1, arr2);
        System.out.println("Median element is " + result);
    }

    private static double findMedian(int[] arr1, int[] arr2) {

        if (arr2.length < arr1.length) {
            findMedian(arr2, arr1);
        }
        int n1 = arr1.length;
        int n2 = arr2.length;
        int low = 0;
        int high = n1;

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int r1 = cut1 == 0 ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == 0 ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }

        }
        return 0;
    }
}
