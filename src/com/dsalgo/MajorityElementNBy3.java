package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementNBy3 {
    public static void main(String[] args) {
        int[] arr = {7, 7, 5, 7, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};

        List<Integer> majorElements = findMajorityElement(arr);
        System.out.println("Majority n/3 elements are-");
        majorElements.forEach(System.out::println);

    }

    private static List<Integer> findMajorityElement(int[] arr) {
        int count1 = 0, count2 = 0;
        int n = (int) Math.floor(arr.length / 3);
        int candidate1 = 0, candidate2 = 0;
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate1) {
                count1++;
            } else if (arr[i] == candidate2) {
                count2++;
            }
        }
        if (count1 > n) {
            ans.add(candidate1);
        }
        if (count2 > n) {
            ans.add(candidate2);
        }

        return ans;
    }
}