package com.dsalgo;

public class MajorityElementNBy2 {

    public static void main(String[] args) {
        int[] arr = {7, 7, 5, 7, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};

        int majorElement = findMajorityElement(arr);
        System.out.println("Majority n/2 element:" + majorElement);

    }

    private static int findMajorityElement(int[] arr) {
        int count = 0;
        int candidate = 0;
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
