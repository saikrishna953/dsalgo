package com.dsalgo.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    public static void main(String[] args) {

        StackDs stackDs = new StackDs();

        stackDs.push(2);
        stackDs.push(3);
        stackDs.push(6);
        System.out.println("first pop-" + stackDs.pop());
        System.out.println("second pop-" + stackDs.pop());
        System.out.println("size-" + stackDs.size());
        System.out.println("top ele-" + stackDs.top());
        System.out.println("third pop-" + stackDs.pop());
        System.out.println("fourth pop-" + stackDs.pop());

    }

    static class StackDs {

        Queue<Integer> q = new LinkedList<>();

        StackDs() {

        }

        public void push(int num) {
            q.add(num);
            for (int i = 0; i < q.size() - 1; i++) {
                q.add(q.remove());
            }
        }

        public int pop() {
            if (q.isEmpty()) {
                return -1;
            }
            return q.remove();
        }

        public int top() {
            if (q.isEmpty()) {
                return -1;
            }
            return q.peek();
        }

        public int size() {
            return q.size();
        }
    }
}
