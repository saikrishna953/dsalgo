package com.dsalgo;

import java.util.HashMap;

public class LongestSubStringWithoutRep {

    public static void main(String[] args) {
        String x = "abcaabcdba";
        int ans = findLenOfLongestSubStringWithoutRepeatingCharacters(x);
        System.out.println("Answer is:" + ans);
    }

    private static int findLenOfLongestSubStringWithoutRepeatingCharacters(String x) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        int left = 0, right = 0;
        int len = 0;
        if (x.chars().distinct().count() != x.length()) {
            System.out.println("no uniqueness");
        }
        while (right < x.length()) {
            if (mpp.containsKey(x.charAt(right))) {
                left = Math.max(mpp.get(x.charAt(right)) + 1, left);
            }
            mpp.put(x.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    // This function returns true if all characters in
// str[i..j] are distinct, otherwise returns false
    public static Boolean areDistinct(String str,
                                      int i, int j) {

        // Note : Default values in visited are false
        boolean[] visited = new boolean[26];

        for (int k = i; k <= j; k++) {
            if (visited[str.charAt(k) - 'a'])
                return false;

            visited[str.charAt(k) - 'a'] = true;
        }
        return true;
    }

    // Returns length of the longest substring
// with all distinct characters.
    public static int longestUniqueSubstr(String str) {
        int n = str.length();

        // Result
        int res = 0;

        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (areDistinct(str, i, j))
                    res = Math.max(res, j - i + 1);

        return res;
    }
}
