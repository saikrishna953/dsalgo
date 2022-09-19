package com.dsalgo.dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String result = findLCS("passport", "ppsspt");

        System.out.println("Result:" + result);
        LongestCommonSubstring l = new LongestCommonSubstring();
        String k = "123";
        l.mymethod(k);
        System.out.println(k);

        int num = 8;
        System.out.println(16%16);

    }

    private void mymethod(String k) {
        dd x = new dd();
        x.s = 10;
        mymethod2(x);
        System.out.println(x.s);
        k = "321";
    }

    private void mymethod2(dd x) {
        x.s = 2;
    }

    class dd {
        Integer s;

        dd() {

        }
    }

    private static String findLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int maxLength = 0;
        int endIndex = Integer.MIN_VALUE;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (maxLength < dp[i][j]) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }
        System.out.println("Length:" + maxLength);
        return s1.substring(endIndex - maxLength, endIndex);
    }
}
