package com.dsalgo.linkedlist;

public class DetectCycleInLL {
    public static void main(String[] args) {

        Node linkedListNode1 = new Node(1);
        linkedListNode1.next = new Node(2);
        linkedListNode1.next.next = new Node(8);
        linkedListNode1.next.next.next = new Node(7);
        linkedListNode1.next.next.next.next = new Node(6);
        linkedListNode1.next.next.next.next.next = linkedListNode1.next.next;

        boolean result = isCycleDetected(linkedListNode1);
        System.out.println("Is cycle detected:" + result);

    }

    private static boolean isCycleDetected(Node linkedListNode1) {
        if (linkedListNode1 == null || linkedListNode1.next == null) {
            return false;
        }

        Node slow = linkedListNode1;
        Node fast = linkedListNode1;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
