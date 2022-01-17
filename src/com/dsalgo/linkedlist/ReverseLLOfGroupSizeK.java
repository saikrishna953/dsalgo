package com.dsalgo.linkedlist;

public class ReverseLLOfGroupSizeK {

    public static void main(String[] args) {
        Node linkedListNode = new Node(1);
        linkedListNode.next = new Node(2);
        /*linkedListNode.next.next = new Node(3);
        linkedListNode.next.next.next = new Node(4);
        linkedListNode.next.next.next.next = new Node(5);
        linkedListNode.next.next.next.next.next = new Node(6);
        linkedListNode.next.next.next.next.next.next = new Node(7);
        linkedListNode.next.next.next.next.next.next.next = new Node(8);*/
        Node newHead = reverseLinkedListOfSizeK(linkedListNode, 2);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    private static Node reverseLinkedListOfSizeK(Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        int cnt = 0;
        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = dummy;
        Node prev = dummy;
        Node nex = dummy;

        while (curr.next != null) {
            curr = curr.next;
            cnt++;
        }
        while (cnt >= k) {
            curr = prev.next;
            nex = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            cnt -= k;
        }
        return dummy.next;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

