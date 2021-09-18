package com.dsalgo;

public class StockBuySell {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        int maxProfit = maxProfit(arr);
        System.out.println("Max profit:" + maxProfit);
    }

    private static int maxProfit(int[] arr) {

        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min_price) {
                min_price = arr[i];
            } else if ((arr[i] - min_price) > max_profit) {
                max_profit = arr[i] - min_price;
            }
        }
        return max_profit;

    }
}