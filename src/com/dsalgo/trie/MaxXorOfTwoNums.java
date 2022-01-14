package com.dsalgo.trie;

import java.util.Arrays;

public class MaxXorOfTwoNums {

    TrieBinaryNode root;

    MaxXorOfTwoNums() {
        root = new TrieBinaryNode();
    }

    public static void main(String[] args) {

        int[] arr1 = {6, 6, 0, 6, 8, 5, 6};
        int[] arr2 = {1, 7, 1, 7, 8, 0, 2};
        int result = solution(arr1, arr2);
        System.out.println("Result-" + result);
    }

    private static int solution(int[] arr1, int[] arr2) {

        MaxXorOfTwoNums maxXorOfTwoNums = new MaxXorOfTwoNums();
        Arrays.stream(arr1).forEach(maxXorOfTwoNums::insert);
        int max = 0;
        for (int i = 0; i < arr2.length; i++) {
            max = Math.max(max, maxXorOfTwoNums.getMax(arr2[i]));
        }

        return max;
    }

    public int getMax(int num) {
        TrieBinaryNode node = root;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                max = max | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return max;

    }

    public void insert(int num) {

        TrieBinaryNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new TrieBinaryNode());
            }
            node = node.get(bit);
        }
        node.setEnd();
    }

    class TrieBinaryNode {
        TrieBinaryNode[] links = new TrieBinaryNode[2];
        boolean isEndOfNumber;

        TrieBinaryNode() {
            isEndOfNumber = false;
        }

        boolean containsKey(int c) {
            return (links[c] != null);
        }

        TrieBinaryNode get(int c) {
            return links[c];
        }

        void put(int c, TrieBinaryNode node) {
            links[c] = node;
        }

        void setEnd() {
            isEndOfNumber = true;
        }

        boolean isEnd() {
            return isEndOfNumber;
        }


    }
}
