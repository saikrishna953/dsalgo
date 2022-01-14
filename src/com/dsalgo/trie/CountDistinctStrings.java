package com.dsalgo.trie;

//https://www.geeksforgeeks.org/count-distinct-substrings-string-using-suffix-trie/
//tc-o(n^2)
public class CountDistinctStrings {

    public static void main(String[] args) {

        String input = "abc";
        CountDistinctStrings c = new CountDistinctStrings();
        Integer result = c.countDistinctSubstrings(input);
        System.out.println("Result-" + result);
    }

    private int countDistinctSubstrings(String s) {
        Trie trie = new Trie();
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Trie.TrieNode node = trie.getRoot();
            for (int j = i; j < n; j++) {
                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Trie.TrieNode());
                    cnt++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return cnt + 1;
    }
}
