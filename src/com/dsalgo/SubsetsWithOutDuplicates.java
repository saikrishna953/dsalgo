package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//time-
//space-
public class SubsetsWithOutDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};

        List<List<Integer>> result = subsets(arr, arr.length);
        result.forEach(l -> {
            System.out.println();
            l.forEach(s -> System.out.print(s + " "));
        });
    }

    private static List<List<Integer>> subsets(int[] arr, int N) {

        //to have duplicates in order
        Arrays.sort(arr);
        List<List<Integer>> subsets = new ArrayList<>();
        func(0, arr, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void func(int ind, int[] arr, List<Integer> ds, List<List<Integer>> subsets) {

        subsets.add(new ArrayList<>(ds));
        for (int i = ind; i < arr.length; i++) {
            if (i != ind && arr[i] == arr[i - 1]) {
                continue;
            }
            ds.add(arr[i]);
            func(i + 1, arr, ds, subsets);
            ds.remove(ds.size() - 1);
        }

    }
}
