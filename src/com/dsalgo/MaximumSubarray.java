package com.dsalgo;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        
        findMaximumSubArraySum(arr);
        findMaximumSubArray(arr);
    }

    private static void findMaximumSubArray(int[] arr) {

        int sum = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        int s = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
            if(max < sum){
                max = sum;
                start=s;
                end=i;
            }
            if(sum < 0){
                sum = 0;
                s= i+1;
            }
        }
        System.out.println("Start index:" + start);
        System.out.println("End index:" + end);
    }

    //Kadane algorithm-Maximum sum of contiguous subarray.
    private static void findMaximumSubArraySum(int[] arr) {

        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum+arr[i]);
            max = Math.max(sum,max);
        }
        System.out.println("Maximum sum:" + max);

    }
}
