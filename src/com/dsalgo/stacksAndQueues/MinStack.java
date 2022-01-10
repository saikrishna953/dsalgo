package com.dsalgo.stacksAndQueues;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum element is " + minStack.getMin());
        System.out.println("Popped element is " + minStack.pop());
        System.out.println("Top element is " + minStack.top());
        System.out.println("Minimum element is " + minStack.getMin());

    }

    Stack<Long> stack = new Stack<>();
    long minValue;

    public MinStack() {
        minValue = Long.MAX_VALUE;
    }

    public void push(Integer val) {

        Long value = Long.valueOf(val);
        if (stack.isEmpty()) {
            stack.push(value);
            minValue = value;
        } else if (value < minValue) {
            long p = 2 * value - minValue;
            minValue = value;
            stack.push(p);
        } else {
            stack.push(value);
        }

    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return -1;
        } else if (stack.peek() < minValue) {
            Long val = stack.pop();
            Long oldMinValue = minValue;
            minValue = 2 * minValue - val;
            return oldMinValue.intValue();
        }
        return -1;
    }

    public Integer top() {
        if (stack.isEmpty()) {
            return -1;
        } else if (stack.peek() < minValue) {
            return (int) minValue;
        }
        return stack.peek().intValue();
    }

    public Integer getMin() {
        return (int) minValue;
    }
}
