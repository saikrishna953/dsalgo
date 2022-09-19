package com.dsalgo.dp;

public class LengthOfLongestPalindromeSubsequence {

    public static void main(String[] args) {
        int result = findLPSLength("abdbca");
        System.out.println("result:" + result);
    }

    private static int findLPSLength(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return findLPSLengthRecursive(s, dp, 0, s.length() - 1);
    }

    private static int findLPSLengthRecursive(String s, Integer[][] dp, int startIndex,
                                              int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }
        if (dp[startIndex][endIndex] == null) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(s, dp, startIndex + 1, endIndex - 1);
            } else {
                int c1 = findLPSLengthRecursive(s, dp, startIndex + 1, endIndex);
                int c2 = findLPSLengthRecursive(s, dp, startIndex, endIndex - 1);
                dp[startIndex][endIndex] = Math.max(c1, c2);
            }

        }
        return dp[startIndex][endIndex];
    }
}
