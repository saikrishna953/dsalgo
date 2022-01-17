package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//o(n^3)-time complexity
public class FourSum {

    public static void main(String[] args) {
        int[] arr = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;

        List<ArrayList<Integer>> result = findIndexesOfFourSum(arr, target);
        result.forEach(integers -> {
            integers.forEach(integer -> {
                System.out.print(integer + ",");
            });
            System.out.println();
        });

    }

    private static List<ArrayList<Integer>> findIndexesOfFourSum(int[] arr, int target) {

        List<ArrayList<Integer>> result = new ArrayList<>();
        if (arr.length < 2) {
            return result;
        } else {
            Arrays.sort(arr);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int target_2 = target - arr[i] - arr[j];
                int front = j + 1;
                int back = arr.length - 1;
                while (front < back) {
                    if (arr[front] + arr[back] < target_2) {
                        front++;
                    } else if (arr[front] + arr[back] > target_2) {
                        back--;
                    } else {
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[front]);
                        quad.add(arr[back]);
                        result.add(quad);

                        //processing the duplicates
                        while (front < back && arr[front] == quad.get(2)) {
                            ++front;
                        }

                        while (front < back && arr[back] == quad.get(3)) {
                            --back;
                        }

                    }
                }

                while ((j + 1 < arr.length) && arr[j + 1] == arr[j]) {
                    ++j;
                }
            }
            while ((i + 1 < arr.length) && arr[i + 1] == arr[i]) {
                ++i;
            }

        }
        return result;
    }
}
