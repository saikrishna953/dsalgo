package com.dsalgo.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        //String[] strs = {"dog", "racecar", "car"};
        String[] strs = {"flower", "flow", "flight"};
        String result = solution(strs);
        System.out.println(result);
    }

    private static String solution(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int low = 0;
        int minLen = Integer.MAX_VALUE;
        for (String s : strs
        ) {
            minLen = Math.min(minLen, s.length());
        }
        int high = minLen - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int mid) {
        String prefix = strs[0].substring(0, mid);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
