package com.dsalgo;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithXorAsK {

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = findCountOfSubArraysWithXorAsK(arr, k);
        System.out.println("Count of Sub Arrays:" + ans);

    }

    //time-n log n
    private static int findCountOfSubArraysWithXorAsK(int[] arr, int k) {
        int cnt = 0;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            xor = xor ^ num;

            if (map.containsKey(xor ^ k)) {
                cnt = cnt + map.get(xor ^ k);
            }
            if (xor == k) {
                cnt++;
            }
            if (map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }
        return cnt;
    }
}
