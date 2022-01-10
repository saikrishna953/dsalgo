package com.dsalgo.stacksAndQueues;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};

        int maxTwoPass = twoPass(heights);
        System.out.println("Two pass result " + maxTwoPass);
        int maxOnePass = onePass(heights);
        System.out.println("One pass result " + maxOnePass);
    }

    private static int onePass(int[] heights) {

        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                max = Math.max(max, width * height);
            }
            stack.push(i);

        }
        return max;
    }

    private static int twoPass(int[] heights) {
        int n = heights.length;
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        while (stack.isEmpty()) {
            stack.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightSmall[i] = n - 1;
            } else {
                rightSmall[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, ((rightSmall[i] - leftSmall[i] + 1) * heights[i]));
        }

        return max;

    }
}
