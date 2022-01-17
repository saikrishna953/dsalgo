package com.dsalgo.linkedlist;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Node linkedListNode = new Node(1);
        linkedListNode.next = new Node(2);
        linkedListNode.next.next = new Node(3);
        linkedListNode.next.next.next = new Node(4);
        linkedListNode.next.next.next.next = new Node(5);
        linkedListNode.next.next.next.next.next = new Node(6);
        Node newHead = middleLinkedList(linkedListNode);
        System.out.println("Middle element is:" + newHead.val);
    }

    private static Node middleLinkedList(Node linkedListNode) {
        Node slow = linkedListNode;
        Node fast = linkedListNode;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /*while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }*/
        return slow;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
