package com.dsalgo.stacksAndQueues;

import java.util.Stack;

public class ImplementQueueUsingStack {

    public static void main(String[] args) {

        QueueDs queueDs = new QueueDs();
        queueDs.push(3);
        queueDs.push(2);
        queueDs.push(1);
        queueDs.push(8);
        queueDs.push(6);
        queueDs.push(7);
        System.out.println("Top element is " + queueDs.top());
        System.out.println("Popped element is " + queueDs.pop());
        System.out.println("Top element is " + queueDs.top());
        System.out.println("Size " + queueDs.size());
    }

    static class QueueDs {

        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        QueueDs() {

        }

        public void push(int num) {
            input.add(num);
        }

        public int pop() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public int top() {

            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();

        }

        int size() {
            return (output.size() + input.size());
        }

    }
}
