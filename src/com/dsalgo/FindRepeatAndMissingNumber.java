package com.dsalgo;

public class FindRepeatAndMissingNumber {
    public static void main(String[] args) {
        System.out.println("Sai");
        int[] arr = {4, 3, 4, 2, 5};

        //1st problem
        //findRepeatAndMissingElement1(arr);
        findRepeatAndMissingElement2(arr);

    }

    //Use elements as Index and mark the visited places
    private static void findRepeatAndMissingElement2(int[] arr) {
        int i;
        System.out.print("The repeating element is ");

        for (i = 0; i < arr.length; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0) {
                arr[abs_val - 1] = -arr[abs_val - 1];
            } else {
                System.out.println(abs_val);
                break;
            }
        }

        System.out.print("And the missing element is ");
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    //Use count array
    private static void findRepeatAndMissingElement1(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return;
        }
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            ++arr1[arr[i] - 1];
        }
        for (int i = 0; i < n; i++) {
            if (arr1[i] == 0) {
                System.out.println("Missing number:" + (i + 1));
            }
            if (arr1[i] > 1) {
                System.out.println("Repeating number:" + (i + 1));
            }
        }
    }
}
