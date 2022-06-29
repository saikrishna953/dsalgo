package com.dsalgo.stacksAndQueues;

import java.util.Stack;

/*Given an array, print the Next Greater Element (NGE) for every element.
The Next greater Element for an element x is the first greater element on the
right side of x in the array. Elements for which no greater element exist,
consider the next greater element as -1.*/
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

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);

        }
        return nge;
    }
}
