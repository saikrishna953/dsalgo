package com.dsalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//time-O(2^N + 2^Nlog(2^N))
//space-O(N)
public class SubsetSums {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};

        ArrayList<Integer> result = subsetSums(arr, arr.length);
        result.forEach(System.out::println);
    }

    private static ArrayList<Integer> subsetSums(int[] arr, int N) {

        ArrayList<Integer> subsets = new ArrayList<>();
        func(0, 0, arr, N, subsets);
        Collections.sort(subsets);
        return subsets;
    }

    private static void func(int ind, int sum, int[] arr, int N, List<Integer> subsets) {

        if (ind == N) {
            subsets.add(sum);
            return;
        }

        //pick the element
        func(ind + 1, sum + arr[ind], arr, N, subsets);

        //do not pick the element
        func(ind + 1, sum, arr, N, subsets);
    }
}
