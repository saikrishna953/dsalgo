package com.dsalgo;

//https://leetcode.com/problems/trapping-rain-water/
public class Trappingrainwater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int res = findAmountOfTrappedWater(arr);
        System.out.println("Result:" + res);
    }

    private static int findAmountOfTrappedWater(int[] arr) {

        int leftMax = 0, rightMax = 0, res = 0, l = 0, r = arr.length - 1;

        while (l <= r) {

            if (arr[l] <= arr[r]) {
                if (arr[l] >= leftMax) {
                    leftMax = arr[l];
                } else {
                    res += Math.abs(leftMax - arr[l]);
                }

                l++;
            } else {
                if (arr[r] >= rightMax) {
                    rightMax = arr[r];
                } else {
                    res += Math.abs(rightMax - arr[r]);
                }

                r--;
            }
        }
        return res;
    }
}
