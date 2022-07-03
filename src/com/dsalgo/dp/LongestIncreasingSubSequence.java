package com.dsalgo.dp;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 6, 10, 1, 12};

        System.out.println("Count:" + method1(nums));

        int[] nums2 = {-4,10,3,7,15};

        System.out.println("Count 1:" + method1(nums2));
    }

    private static int method1(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length + 1];
        return findSequence(nums, dp, 0, -1);
    }

    private static int findSequence(int[] nums, Integer[][] dp, int currIndex, int prevIndex) {
        if (currIndex == nums.length) {
            return 0;
        }
        if (dp[currIndex][prevIndex + 1] == null) {
            int c1 = 0;
            int c2 = 0;
            if (prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
                c1 = 1 + findSequence(nums, dp, currIndex + 1, currIndex);
            }
            c2 = findSequence(nums, dp, currIndex + 1, prevIndex);
            dp[currIndex][prevIndex + 1] = Math.max(c1, c2);

        }
        return dp[currIndex][prevIndex + 1];
    }
}
