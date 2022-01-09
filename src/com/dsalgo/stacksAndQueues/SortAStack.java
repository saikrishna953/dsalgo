package com.dsalgo.stacksAndQueues;

import java.util.Stack;

public class SortAStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        Stack<Integer> result = sortStack(stack);
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }

    private static Stack<Integer> sortStack(Stack<Integer> stack) {

        Stack<Integer> tmpStack = new Stack<>();
        while (!stack.isEmpty()) {

            int tmp = stack.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                stack.push(tmpStack.pop());
            }
            tmpStack.push(tmp);

        }
        return tmpStack;
    }
}
