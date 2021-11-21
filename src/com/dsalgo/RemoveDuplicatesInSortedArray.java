package com.dsalgo;

public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3};
        int res = findNumberOfUniqueElements(arr);
        System.out.println("Result:" + res);
    }

    private static int findNumberOfUniqueElements(int[] arr) {

        if(arr.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < arr.length; j++) {

            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }

        }
        return i + 1;
    }
}