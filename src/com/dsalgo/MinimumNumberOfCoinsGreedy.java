package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfCoinsGreedy {

    public static void main(String[] args) {
        int[] deno = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        int V = 39;
        int answer = findMinimumNumberOfCoins(deno, V);
        System.out.println("Answer:" + answer);
    }

    private static int findMinimumNumberOfCoins(int[] deno, int v) {

        List<Integer> ans = new ArrayList<>();
        int currValue = v;
        for (int i = deno.length - 1; i > 0; i--) {

            while (currValue >= deno[i]) {
                ans.add(deno[i]);
                currValue -= deno[i];
            }
        }
        ans.forEach(System.out::println);
        return ans.size();

    }
}
