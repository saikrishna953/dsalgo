package com.dsalgo.stacksAndQueues;

public class ImplementStackUsingArray {

    public static void main(String[] args) {

        StackDs stackDs = new ImplementStackUsingArray.StackDs();
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

        int size = 10000;
        int top = -1;
        int[] arr;

        StackDs() {
            arr = new int[size];
        }

        void push(int number) {
            top++;
            arr[top] = number;
        }

        int pop() {
            if (top != -1) {
                int ind = top;
                top--;
                return arr[ind];
            } else {
                return -1;
            }

        }

        int top() {
            if (top != -1) {
                return arr[top];
            } else {
                return -1;
            }
        }

        int size() {
            return top + 1;
        }
    }
}
