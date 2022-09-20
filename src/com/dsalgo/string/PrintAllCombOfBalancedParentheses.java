package com.dsalgo.string;

import java.util.ArrayList;

//tc-O(2^n)
//sc-O(n)
//https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
public class PrintAllCombOfBalancedParentheses {

    public static void main(String[] args) {
        int n = 3;

        ArrayList<String> ans = new ArrayList<>();

        generateParenthesis(n, 0, 0, "", ans);

        // Now, here we print out all the combinations.
        for (String s : ans) {
            System.out.println(s);
        }
    }

    private static void generateParenthesis(int n, int open, int close, String s, ArrayList<String> ans) {
        if (open == n && close == n) {
            ans.add(s);
            return;
        }

        if (open < n) {
            generateParenthesis(n, open + 1, close, s + "{",
                    ans);
        }

        if (open > close) {
            generateParenthesis(n, open, close + 1, s + "}", ans);
        }
    }
}
