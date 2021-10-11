package com.dsalgo;

import java.util.HashMap;

public class LargestSubArrayWithZeroSum {

    public static void main(String[] args) {
        int[] nums = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        int ans = findLargestSubArrayWithZeroSum(nums);
        System.out.println("Largest Sub array with zero sum:" + ans);
    }

    //o(N log N)
    private static int findLargestSubArrayWithZeroSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }
}
