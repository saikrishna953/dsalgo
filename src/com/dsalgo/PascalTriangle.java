package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> result = generate(7);
        /*result.forEach(integers -> {
            integers.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });*/
        int rows = result.size();
        for (int i = 0; i < rows; i++) {

            for (int space = 0; space < rows-i; space++) {
                System.out.print(" ");
            }
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr, pre = null;

        for (int i = 0; i < numRows; i++) {

            arr = new ArrayList<>();


            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    arr.add(1);
                } else {
                    arr.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = arr;
            result.add(arr);

        }
        return result;

    }
}
