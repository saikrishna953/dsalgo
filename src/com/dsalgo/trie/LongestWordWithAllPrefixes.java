package com.dsalgo.trie;

import java.util.List;

//https://leetcode.com/problems/longest-word-with-all-prefixes/
//tc-o(n) * o(len) ; len-average length of strings
//sc-o(n*len)
public class LongestWordWithAllPrefixes {
    public static void main(String[] args) {
        //List<String> input = List.of("n", "ni", "nin", "ninj", "ninja", "ninga");
        List<String> input = List.of("g", "a", "ak", "szhkb", "hy");
        //List<String> input = List.of("kez", "vfj", "vfjq", "vfjqo");
        String answer = completeString(input);
        System.out.println("Result-" + answer);
    }

    private static String completeString(List<String> input) {

        Trie trie = new Trie();
        input.forEach(trie::insert);
        String longest = "";
        for (String word : input
        ) {
            if (trie.checkIfAllPrefixesExists(word)) {
                if (longest.length() < word.length()) {
                    longest = word;
                    //if both the strings lengths are equal, check for lexicographical order
                } else if (word.length() == longest.length() && (word.compareTo(longest) < 0)) {
                    longest = word;
                }
            }
        }
        if (longest.isEmpty()) {
            return "None";
        } else {
            return longest;
        }

    }
}

