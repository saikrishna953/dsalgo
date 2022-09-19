package com.dsalgo.dp;

//https://www.geeksforgeeks.org/painters-partition-problem/
public class PaintersPartitionProblem {

    static int sum(int arr[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }


    static int findMax(int arr[], int n, int k) {
        int dp[][] = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++)
            dp[1][i] = sum(arr, 0, i - 1);

        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        // 2 to k partitions
        for (int i = 2; i <= k; i++) { // 2 to n boards
            for (int j = 2; j <= n; j++) {

                // track minimum
                int best = Integer.MAX_VALUE;

                // i-1 th separator before position arr[p=1..j]
                for (int p = 1; p <= j; p++)
                    best = Math.min(best, Math.max(dp[i - 1][p],
                            sum(arr, p, j - 1)));

                dp[i][j] = best;
            }
        }

        // required
        return dp[k][n];
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {10, 20, 60, 50, 30, 40};

        // Calculate size of array.
        int n = arr.length;
        int k = 3;
        System.out.println(findMax(arr, n, k));
    }
}


