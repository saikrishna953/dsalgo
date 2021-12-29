package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};

        int target = 7;
        List<List<Integer>> result = combinationSums(arr, target);
        result.forEach(l -> {
            System.out.println();
            l.forEach(s -> System.out.print(s + " "));
        });
    }

    private static List<List<Integer>> combinationSums(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        func(0, target, arr, ans, new ArrayList<Integer>());
        return ans;
    }

    private static void func(int ind, int target, int[] arr, List<List<Integer>> ans,
                             ArrayList<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            func(ind, target - arr[ind], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }
        func(ind + 1, target, arr, ans, ds);

    }
}
