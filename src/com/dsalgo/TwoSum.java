package com.dsalgo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;

        int[] result = findIndexesOfTwoSum(arr,target);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] findIndexesOfTwoSum(int[] arr, int target) {

        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(Math.abs(target - arr[i]))){
                result[1]= i;
                result[0] = map.get(Math.abs(target-arr[i]));
                break;
            }else{
                map.put(arr[i],i);
            }
        }
        return result;
    }
}
