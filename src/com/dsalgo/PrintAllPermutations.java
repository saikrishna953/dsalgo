package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
//tc-n! * n
//sc-n!
public class PrintAllPermutations {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = permute(arr);
        result.forEach(l -> {
            System.out.println();
            l.forEach(s -> System.out.print(s + " "));
        });

    }

    private static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, arr, ans);
        return ans;
    }

    private static void recurPermute(int ind, int[] arr, List<List<Integer>> ans) {
        if (ind == arr.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                ds.add(arr[i]);
            }
            ans.add(ds);
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            swap(arr, ind, i);
            recurPermute(ind + 1, arr, ans);
            //to re-swap
            swap(arr, ind, i);
        }
    }

    private static void swap(int[] arr, int ind, int i) {
        int t = arr[ind];
        arr[ind] = arr[i];
        arr[i] = t;
    }
}
