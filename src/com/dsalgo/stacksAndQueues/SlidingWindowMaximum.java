package com.dsalgo.stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//https://leetcode.com/problems/sliding-window-maximum/
//tc=o(n)+o(n)~o(n)
//sc-o(k)
public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution(arr, k);
        Arrays.stream(result).forEach(System.out::println);

    }

    private static int[] solution(int[] arr, int k) {
        int n = arr.length;
        int result[] = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek() == i - k) {
                q.pollFirst();
            }
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                result[ri++] = arr[q.peekFirst()];
            }
        }
        return result;
    }
}
