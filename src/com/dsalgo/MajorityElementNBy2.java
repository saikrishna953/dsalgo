package com.dsalgo;

public class MajorityElementNBy2 {

    public static void main(String[] args) {
        //int[] arr = {7, 7, 5, 7, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        int[] arr = {3,3,4};

        int majorElement = findMajorityElement(arr);
        System.out.println("Majority n/2 element:" + majorElement);

    }

    private static int findMajorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
