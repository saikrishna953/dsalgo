package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
public class Triplets {

    public static void main(String[] args) {
        int[] arr = {-1, -2, -2, -1, -1, 2, 0, 2, 0, 0, 2};

        List<List<Integer>> result = findTriplets(arr);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> findTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {

            if (i == 0 || (i > 0 && (arr[i] != arr[i - 1]))) {
                int lo = i + 1;
                int hi = arr.length - 1;
                int sum = -arr[i];
                while (lo < hi) {
                    if (arr[lo] + arr[hi] == sum) {

                        result.add(Arrays.asList(arr[i],arr[lo],arr[hi]));
                        while(lo< hi && (arr[lo] == arr[lo+1])){
                            lo++;
                        }
                        while(lo< hi && (arr[hi] == arr[hi-1])){
                            hi--;
                        }
                        lo++;hi--;
                    }else if(arr[lo] + arr[hi] < sum){
                        lo++;
                    }else{
                        hi--;
                    }
                }
            }
        }
        return result;
    }
}
