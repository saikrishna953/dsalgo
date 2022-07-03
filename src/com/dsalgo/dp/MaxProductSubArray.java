package com.dsalgo.dp;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int nums[] = {1, 2, -3, 0, -4, -5};
        int answer = maxProductSubArray(nums);
        System.out.print("The maximum product subarray is: " + answer);
    }

    private static int maxProductSubArray(int[] arr) {
        int prod1 = arr[0], prod2 = arr[0];
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(prod1 * arr[i], prod2 * arr[i]));
            prod2 = Math.min(arr[i], Math.min(prod1 * arr[i], prod2 * arr[i]));
            prod1 = temp;

            result = Math.max(result,prod1);
        }
        return result;
    }
}
