package com.dsalgo.stacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/
//tc-o(n)
//sc-o(n)
public class StockSpan {

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = solution(prices, prices.length);
        Arrays.stream(spans).forEach(System.out::println);
    }

    private static int[] solution(int[] prices, int length) {
        int[] spans = new int[length];
        if (length < 1) {
            return spans;
        }

        Stack<Integer> s = new Stack<>();
        s.push(0);
        spans[0] = 1;
        for (int i = 1; i < length; i++) {

            while (!s.isEmpty() && prices[i] > prices[s.peek()]) {
                s.pop();
            }
            spans[i] = s.isEmpty() ? i + 1 : (i - s.peek());
            s.push(i);
        }
        return spans;
    }
}
