package com.dsalgo.stacksAndQueues;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int arr[] = {5, 7, 1, 2, 6, 0};

        int arr2[] = nextGreaterElements(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    private static int[] nextGreaterElements(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    nge[i] = stack.peek();
                } else {
                    nge[i] = -1;
                }
            }
            stack.push(arr[i % n]);

        }
        return nge;
    }
}
