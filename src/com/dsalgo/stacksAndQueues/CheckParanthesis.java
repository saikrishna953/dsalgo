package com.dsalgo.stacksAndQueues;

import java.util.Stack;

public class CheckParanthesis {

    public static void main(String[] args) {
        String s = "{([])}";
        System.out.println("isValid:" + isValid(s));

    }

    private static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()
        ) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char it = stack.pop();
                if ((c == ')' && it == '(') || (c == ']' && it == '[') || (c == '}' && it == '{')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
