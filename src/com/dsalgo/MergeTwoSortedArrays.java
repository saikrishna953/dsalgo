package com.dsalgo;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("Sai");
        int[] arr = {4, 3, 4, 2, 5};
        //2nd problem
        int nums1[] = new int[]{1, 5, 9, 10, 15, 20};
        int nums2[] = new int[]{2, 3, 8, 13};
        merge1(nums1, nums1.length, nums2, nums2.length);
        System.out.print("After Merging First Array: ");
        System.out.println(Arrays.toString(nums1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(nums2));
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

        int gap = m + n;
        int i = 0, j = 0;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            for (i = 0; i + gap < m; i++) {
                if (nums1[i] > nums1[i + gap]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[i + gap];
                    nums1[i + gap] = temp;
                }
            }

            for (j = gap > m ? gap - m : 0;
                 i < m && j < n;
                 i++, j++) {
                if (nums1[i] > nums2[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums2[j];
                    nums2[j] = temp;
                }
            }
            if (j < n) {
                for (j = 0; j + gap < n; j++) {
                    if (nums2[j] > nums2[j + gap]) {
                        int temp = nums2[j];
                        nums2[j] = nums2[j + gap];
                        nums2[j + gap] = temp;
                    }
                }
            }
        }

    }

    public static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        } else {
            return (gap / 2) + (gap % 2);
        }
    }

    private static void merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        for (int i = 0; i < m; i++) {
            int curr = nums1[i];
            if (nums1[i] > nums2[0]) {
                int nums20 = nums2[0];
                nums2[0] = curr;
                nums1[i] = nums20;
                Arrays.sort(nums2);
            }

        }
    }
}
