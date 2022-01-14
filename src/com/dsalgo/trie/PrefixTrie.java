package com.dsalgo.trie;

public class PrefixTrie {

    static PrefixTrieNode root;

    static class PrefixTrieNode {
        private PrefixTrieNode[] children = new PrefixTrieNode[26];
        private boolean isEndOfWord;
        private int cntEndWith, cntPrefix;

        PrefixTrieNode() {
            isEndOfWord = false;
            cntEndWith = 0;
            cntPrefix = 0;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

        void increaseEnd() {
            cntEndWith++;
        }

        void increasePrefix() {
            cntPrefix++;
        }

        void deleteEnd() {
            cntEndWith--;
        }

        void reducePrefix() {
            cntPrefix--;
        }

        int getEnd() {
            return cntEndWith;
        }

        int getPrefix() {
            return cntPrefix;
        }

        boolean containsKey(Character c) {
            return (children[c - 'a'] != null);
        }

        PrefixTrieNode get(Character c) {
            return children[c - 'a'];
        }

        void put(Character c, PrefixTrieNode node) {
            children[c - 'a'] = node;
        }

        void setEnd() {
            isEndOfWord = true;
        }

        boolean isEnd() {
            return isEndOfWord;
        }
    }

    public void insert(String word) {

        PrefixTrieNode node = root;

        for (char c : word.toCharArray()
        ) {
            if (!node.containsKey(c)) {
                node.put(c, new PrefixTrieNode());
            }
            node = node.get(c);
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        PrefixTrieNode node = root;

        for (char c : word.toCharArray()
        ) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        PrefixTrieNode node = root;

        for (char c : word.toCharArray()
        ) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        PrefixTrieNode node = root;

        for (char c : word.toCharArray()
        ) {
            if (node.containsKey(c)) {
                node = node.get(c);
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.deleteEnd();
    }
}
