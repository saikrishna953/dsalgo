package com.dsalgo.dp;

/*Given strings s1 and s2, we need to transform s1 into s2 by deleting, inserting,
        or replacing characters. Write a function to calculate the count of the
        minimum number of edit operations.*/
public class EditDistance {

    public static void main(String[] args) {
        String s1 = "abdca";
        String s2 = "cbda";

        System.out.println("Count:" + method(s1, s2));
        System.out.println("Count 1:" + method1(s1, s2));
    }

    //bottom-up
    private static int method1(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private static int method(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];
        return findDistance(dp, s1, s2, 0, 0);
    }

    private static int findDistance(Integer[][] dp, String s1, String s2, int i, int i1) {

        if (dp[i][i1] == null) {

            if (i == s1.length()) {
                dp[i][i1] = s2.length() - i1;
            } else if (i1 == s2.length()) {
                dp[i][i1] = s1.length() - i1;
            } else if (s1.charAt(i) == s2.charAt(i1)) {
                dp[i][i1] = findDistance(dp, s1, s2, i + 1, i1 + 1);
            } else {
                int c1 = findDistance(dp, s1, s2, i + 1, i1);//delete
                int c2 = findDistance(dp, s1, s2, i1, i1 + 1);//insert
                int c3 = findDistance(dp, s1, s2, i1 + 1, i1 + 1);//replace
                dp[i][i1] = 1 + Math.min(c1, Math.min(c2, c3));
            }

        }
        return dp[i][i1];
    }
}
