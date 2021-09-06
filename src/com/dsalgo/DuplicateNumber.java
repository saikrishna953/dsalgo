package com.dsalgo;

public class DuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {3,3,5,4,1,3};
        int result = findDuplicate(nums);
        System.out.println("Duplicate Number:" + result);
    }

    public static int findDuplicate(int[] nums) {

        if (nums.length > 0) {
            while (nums[0] != nums[nums[0]]) {
                int nxt = nums[nums[0]];
                nums[nums[0]] = nums[0];
                nums[0] = nxt;
            }
            return nums[0];
        } else {
            return -1;
        }
    }
}
