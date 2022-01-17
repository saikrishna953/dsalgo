package com.dsalgo.linkedlist;

public class RemoveNthNodeFromEndLL {

    public static void main(String[] args) {
        Node linkedListNode = new Node(1);
        linkedListNode.next = new Node(2);
        linkedListNode.next.next = new Node(3);
        linkedListNode.next.next.next = new Node(4);
        linkedListNode.next.next.next.next = new Node(5);
        Node newHead = removeNode(linkedListNode, 5);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    private static Node removeNode(Node head, int n) {
        Node start = new Node();
        start.next = head;
        Node slow = start;
        Node fast = start;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast.next == null) {
            return head.next;
        } else {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;

            }
            slow.next = slow.next.next;

            return head;
        }

    }

    static class Node {
        int val;
        Node next;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }
    }
}

