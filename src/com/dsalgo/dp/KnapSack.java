package com.dsalgo.dp;

public class KnapSack {

    public static void main(String[] args) {
        int capacity = 5;
        int weights[] = {2, 3, 1, 4};
        int profits[] = {4, 5, 3, 7};
        int result = findMaxProfit(capacity, weights, profits);
        System.out.println("result:" + result);
    }

    private static int findMaxProfit(int capacity, int[] weights, int[] profits) {

        if (profits.length != weights.length) {
            return 0;
        }
        int[] cap = new int[capacity + 1];
        for (int i = 0; i < profits.length; i++) {
            for (int j = capacity; j>=0; j--) {
                if (weights[i] <= j) {
                    cap[j] = Math.max(cap[j], cap[j - weights[i]] + profits[i]);
                }
            }
        }
        return cap[capacity];
    }
}
