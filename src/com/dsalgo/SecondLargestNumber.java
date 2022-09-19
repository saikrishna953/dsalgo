package com.dsalgo;

public class SecondLargestNumber {

    public static void main(String[] args) {
        //int arr[] = {12, 35, 1, 10, 34, 1};

        int arr[] = {12, 12};
        int n = arr.length;
        print2largest(arr, n);
    }

    private static void print2largest(int[] arr, int n) {

        if (n < 2) {
            System.out.println("Invalid Input");
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }

        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("There is no second largest value");
        } else {
            System.out.println("Second largest value is " + second);
        }
    }
}
