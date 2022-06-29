package com.dsalgo.stacksAndQueues;

public class ImplementQueueUsingArray {

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
        System.out.println(1%10);
    }

    static class QueueDs {

        int arr[];
        int start, end, currSize, maxSize;

        QueueDs() {
            start = -1;
            end = -1;
            arr = new int[16];
            maxSize = 16;
        }

        QueueDs(int maxSize) {
            start = -1;
            end = -1;
            arr = new int[maxSize];
            this.maxSize = maxSize;
        }

        public void push(int number) {

            if (currSize == maxSize) {
                System.out.println("Queue is full");
            }

            if (end == -1) {
                start++;
                end++;
            } else {
                end = (end + 1) % maxSize;
            }
            arr[end] = number;
            System.out.println("The element pushed is " + arr[end]);
            currSize++;

        }

        public int pop() {
            if (start == -1) {
                System.out.println("Queue is empty");
            }
            int popped = arr[start];
            if (currSize == 1) {
                start = -1;
                end = -1;
            } else {
                start = (start + 1) % maxSize;
            }
            currSize--;
            return popped;
        }

        public int top() {
            if (start == -1) {
                System.out.println("Queue is empty");
            }
            return arr[start];
        }

        public int size() {
            return currSize;
        }
    }
}
