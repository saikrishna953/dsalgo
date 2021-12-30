package com.dsalgo;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {

    public static void main(String[] args) {
        String input = "aabb";

        List<List<String>> result = palindromePartitioning(input);
        result.forEach(l -> {
            System.out.println();
            l.forEach(s -> System.out.print(s + " "));
        });
    }

    private static List<List<String>> palindromePartitioning(String input) {

        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        func(0, input, ds, ans);
        return ans;
    }

    private static void func(int ind, String input, List<String> ds, List<List<String>> ans) {

        if (ind == input.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < input.length(); i++) {
            if (isPalindrome(input, ind, i)) {
                ds.add(input.substring(ind, i + 1));
                func(i + 1, input, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String input, int start, int end) {
        while (start <= end) {
            if (input.charAt(start++) != input.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
