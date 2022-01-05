package com.dsalgo;

//https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
//tc-log(min(m,n))
public class KthNumberOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 9, 11};
        int[] arr2 = {7, 12, 14, 15};
        int k = 7;
        int result = findKthElement(arr1, arr2, arr1.length, arr2.length, k);
        System.out.println("Kth element is " + result);
    }

    private static int findKthElement(int[] arr1, int[] arr2, int n, int m, int k) {

        if (n > m) {
            return findKthElement(arr2, arr1, m, n, k);
        }
        int low = Math.max(0, k - m);
        int high = Math.min(n, k);

        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }

        }
        return 1;
    }
}
