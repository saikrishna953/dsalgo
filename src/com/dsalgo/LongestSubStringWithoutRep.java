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
}
