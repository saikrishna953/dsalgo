package com.dsalgo.dp;

public class LengthOfLongestPalindromeSubstring {

    public static void main(String[] args) {
        int result = findLPSLength("abdbca");
        System.out.println("result:" + result);
        String result2 = findLPSLengthBottomUp("forgeeksskeegfor");
        System.out.println("result2:" + result2);
    }

    private static String findLPSLengthBottomUp(String st) {
        boolean[][] dp = new boolean[st.length()][st.length()];
        int n = st.length();
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        int start = 0;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        if (maxLength < (endIndex - startIndex + 1)) {
                            maxLength = endIndex - startIndex + 1;
                            start = startIndex;
                        }
                    }
                }
            }
        }
        System.out.println("Length:" + maxLength);
        return st.substring(start, start + maxLength);
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
                int remLength = endIndex - startIndex - 1;
                if (remLength == findLPSLengthRecursive(s, dp, startIndex + 1, endIndex - 1)) {
                    dp[startIndex][endIndex] = 2 + remLength;
                    return dp[startIndex][endIndex];
                }

            }
            int c1 = findLPSLengthRecursive(s, dp, startIndex + 1, endIndex);
            int c2 = findLPSLengthRecursive(s, dp, startIndex, endIndex - 1);
            dp[startIndex][endIndex] = Math.max(c1, c2);


        }
        return dp[startIndex][endIndex];
    }
}
