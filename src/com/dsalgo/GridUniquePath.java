package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridUniquePath {
    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        //n*m matrix
        //brute-find number of ways of reaching from first point to last point
        int ans = findNumberOfWaysBruteForce(0, 0, n, m);
        System.out.println("Brute force answer:" + ans);

        //better-dp
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        int ans2 = findNumberOfWaysDp(0, 0, n, m, dp);
        System.out.println("Dp answer:" + ans2);

        //optimal
        int ans3 = findNumberOfWaysOptimal(n, m);
        System.out.println("Optimal method answer:" + ans3);
    }

    private static int findNumberOfWaysOptimal(int n, int m) {

        int N = m+n-2;
        int r = m-1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N-r+i)/i;
        }
        return (int) res;
    }

    private static int findNumberOfWaysDp(int i, int j, int n, int m, int[][] dp) {
        if (i == n-1 && j == m-1) {
            return 1;
        } else if (i >= n || j >= m) {
            return 0;
        } else {
            if (dp[i][j] != -1) {
                return dp[i][j];
            } else {
                return dp[i][j] = findNumberOfWaysDp(i + 1, j, n, m, dp)
                        + findNumberOfWaysDp(i, j + 1, n, m, dp);
            }
        }
    }

    private static int findNumberOfWaysBruteForce(int i, int j, int n, int m) {

        if (i == n-1 && j == m-1) {
            return 1;
        } else if (i >= n || j >= m) {
            return 0;
        } else {
            return findNumberOfWaysBruteForce(i + 1, j, n, m)
                    + findNumberOfWaysBruteForce(i, j + 1, n, m);
        }
    }
}
