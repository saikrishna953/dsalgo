package com.dsalgo.dp;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "abdca";
        String s2 = "cbda";

        System.out.println("Count:" + method(s1, s2));

        System.out.println("Count 1:" + method1(s1, s2));
    }

    private static int method1(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }
        return maxLength;


    }

    private static int method(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return findSubsequence(s1, s2, dp, 0, 0);
    }

    private static int findSubsequence(String s1, String s2, Integer[][] dp, int i, int i1) {
        if (i == s1.length() || i1 == s2.length()) {
            return 0;
        }
        if (dp[i][i1] == null) {
            if (s1.charAt(i) == s2.charAt(i1)) {
                dp[i][i1] = 1 + findSubsequence(s1, s2, dp, i + 1, i1 + 1);
            } else {
                int c1 = findSubsequence(s1, s2, dp, i + 1, i1);
                int c2 = findSubsequence(s1, s2, dp, i, i1 + 1);
                dp[i][i1] = Math.max(c1, c2);
            }
        }
        return dp[i][i1];
    }
}
