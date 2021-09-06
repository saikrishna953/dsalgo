package com.dsalgo;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] num = {1, 1, 0, 0, 2, 1, 2};

        sortColors(num);
        Arrays.stream(num).forEach(System.out::println);
    }

    private static void sortColors(int[] num) {
        int low = 0, mid = 0;
        int high = num.length - 1;
        while (mid <= high) {
            switch (num[mid]) {
                case 0:
                    int x = num[mid];
                    num[mid] = num[low];
                    num[low] = x;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int x1 = num[mid];
                    num[mid] = num[high];
                    num[high] = x1;
                    high--;
                    break;
            }
        }
    }

}
