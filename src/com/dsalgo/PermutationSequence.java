package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutation-sequence/
//K-th permutation Sequence
//tc-O(N) * O(N)
public class PermutationSequence {

    public static void main(String[] args) {

        String result = getPermutation(4, 17);
        System.out.println(result);
    }

    private static String getPermutation(int n, int k) {

        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1;
        StringBuilder ans = new StringBuilder();
        while (true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans.toString();
    }
}
