package com.dsalgo.dp;

public class MaxSumIncreasingSubSequence {

    public static void main(String[] args) {
        int[] nums = {4,1,2,6,10,1,12};

        System.out.println("Count:" + method1(nums));

    }

    private static int method1(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < nums[i] + dp[j]) {
                    dp[i] = dp[j] + nums[j];
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
