package com.dsalgo.trie;

public class Trie {

    private TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    Trie() {
        this.root = new TrieNode();
    }

    public boolean checkIfAllPrefixesExists(String word) {
        TrieNode node = getRoot();
        boolean flag = true;
        for (char c : word.toCharArray()
        ) {
            if (node.containsKey(c)) {
                node = node.get(c);
                flag = flag & node.isEndOfWord;
            } else {
                return false;
            }
        }
        return flag;
    }

    static class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }

        boolean containsKey(Character c) {
            return (children[c - 'a'] != null);
        }

        TrieNode get(Character c) {
            return children[c - 'a'];
        }

        void put(Character c, TrieNode node) {
            children[c - 'a'] = node;
        }

        void setEnd() {
            isEndOfWord = true;
        }

        boolean isEnd() {
            return isEndOfWord;
        }
    }

    public static void main(String[] args) {
        String keys[] = {"the"};

        String output[] = {"Not present in trie", "Present in trie"};

        Trie trie = new Trie();
        trie.root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            trie.insert(keys[i]);

        // Search for different keys
        if (trie.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if (trie.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if (trie.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if (trie.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }

    public void insert(String s) {
        TrieNode node = this.getRoot();
        for (char c : s.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    public boolean search(String s) {
        TrieNode node = this.getRoot();
        for (char c : s.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return (node != null) && node.isEnd();
    }

    public boolean startWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }


}
