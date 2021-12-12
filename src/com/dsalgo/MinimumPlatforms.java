package com.dsalgo;

import java.util.Arrays;

public class MinimumPlatforms {

    public static void main(String[] args) {

        int arrival[] = {50, 120, 200, 550, 700, 850};
        int departure[] = {500, 550, 600, 700, 900, 1000};

        int answer = getMinimumPlatformsRequired(arrival, departure);
        System.out.println("Answer:" + answer);
    }

    private static int getMinimumPlatformsRequired(int[] arrival, int[] departure) {

        Arrays.sort(arrival);
        Arrays.sort(departure);
        int platforms = 1, result = 1;
        int i = 1, j = 0;

        while (i < arrival.length && j < arrival.length) {

            if (arrival[i] <= departure[j]) {
                platforms++;
                i++;
            } else if (arrival[i] > departure[j]) {
                platforms--;
                j++;
            }
            result = Math.max(platforms, result);
        }

        return result;
    }
}
