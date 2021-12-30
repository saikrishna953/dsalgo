package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
//tc-O(2^N * k), k is the max length of sub arrays
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};

        int target = 8;
        List<List<Integer>> result = combinationSums2(arr, target);
        result.forEach(l -> {
            System.out.println();
            l.forEach(s -> System.out.print(s + " "));
        });
    }

    private static List<List<Integer>> combinationSums2(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        func(0, target, arr, ans, new ArrayList<Integer>());
        return ans;
    }

    private static void func(int ind, int target, int[] arr, List<List<Integer>> ans,
                             ArrayList<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            //if elements at index 3 and 4 are same, take only one at index 3
            if (i > ind && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            ds.add(arr[i]);
            func(i + 1, target - arr[i], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }

    }
}
