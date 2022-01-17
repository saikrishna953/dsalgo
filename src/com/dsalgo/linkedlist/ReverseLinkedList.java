package com.dsalgo.linkedlist;

public class ReverseLinkedList {


    public static void main(String[] args) {
        Node linkedListNode = new Node(1);
        linkedListNode.next = new Node(2);
        linkedListNode.next.next = new Node(3);
        linkedListNode.next.next.next = new Node(4);
        Node newHead = reverseLinkedList(linkedListNode);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    private static Node reverseLinkedList(Node linkedListNode) {
        Node newHead = null;
        while(linkedListNode != null){
            Node next = linkedListNode.next;
            linkedListNode.next = newHead;
            newHead = linkedListNode;
            linkedListNode = next;
        }
        return newHead;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

