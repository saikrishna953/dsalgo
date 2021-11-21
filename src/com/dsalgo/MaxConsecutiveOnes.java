package com.dsalgo;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        int res = findNumberOfConsecutiveOnes(arr);
        System.out.println("Result:" + res);
    }

    private static int findNumberOfConsecutiveOnes(int[] arr) {

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }
}
