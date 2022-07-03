package com.dsalgo.dp;

public class Fibonnaci {

    public static void main(String[] args) {
        int n = 7;
        int result = CalculateFibonacci(n);
        System.out.println("result:" + result);
        System.out.println("result recursive:" + CalculateFibonacci1(n));
    }

    private static int CalculateFibonacci(int n) {

        if (n < 2) {
            return n;
        }
        int n1 = 0, n2 = 1, temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    public static int CalculateFibonacci1(int n) {
        int dp[] = new int[n + 1];
        return CalculateFibonacciRecursive(dp, n);
    }

    public static int CalculateFibonacciRecursive(int[] dp, int n) {
        if (n < 2)
            return n;
        if (dp[n] == 0)
            dp[n] = CalculateFibonacciRecursive(dp, n - 1) + CalculateFibonacciRecursive(dp, n - 2);
        return dp[n];
    }
}
