package com.dsalgo;

import java.util.ArrayList;

//https://leetcode.com/problems/reverse-pairs/
public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {40, 25, 19, 12, 9, 6, 2};
        //int[] nums = {1, 3, 2, 3, 1};

        int ans = findNumberOfReversePairs(nums);
        System.out.println("Number of reverse pairs:" + ans);
    }

    private static int findNumberOfReversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int l, int h) {

        if (l >= h) {
            return 0;
        } else {
            int mid = (l + h) / 2;
            int inv = mergeSort(nums, l, mid);
            inv += mergeSort(nums, mid + 1, h);
            inv += merge(nums, l, mid, h);
            return inv;
        }
    }

    private static int merge(int[] nums, int l, int mid, int h) {

        int j = mid + 1;
        int cnt = 0;
        for (int i = l; i < mid + 1; i++) {
            while (j <= h && (nums[i] > (2 * nums[j]))) {
                j++;
            }
            cnt += (j) - (mid + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int left = l, right = mid + 1;
        while (left <= mid && right <= h) {
            if (nums[left] <= nums[right]) {
                arr.add(nums[left++]);
            } else {
                arr.add(nums[right++]);
            }
        }
        while (left <= mid) {
            arr.add(nums[left++]);
        }

        while (right <= h) {
            arr.add(nums[right++]);
        }

        for (int i = l; i <= h; i++) {
            nums[i] = arr.get(i - l);
        }

        return cnt;
    }
}
