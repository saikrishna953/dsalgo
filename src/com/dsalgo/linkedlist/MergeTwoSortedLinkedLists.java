package com.dsalgo.linkedlist;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        Node linkedNode1 = new Node(1);
        linkedNode1.next = new Node(2);
        linkedNode1.next.next = new Node(4);
        //linkedNode1.next.next.next = new Node(10);

        Node linkedNode2 = new Node(1);
        linkedNode2.next = new Node(3);
        linkedNode2.next.next = new Node(4);

        Node mergedList = merge(linkedNode1, linkedNode2);
        while (mergedList != null) {
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
    }

    private static Node merge(Node l1, Node l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node p1 = l1;
        Node p2 = l2;
        Node head = new Node(-1);
        Node curr = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else if (p1.val > p2.val) {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if (p1 != null) {
            curr.next = p1;
        } else if (p2 != null) {
            curr.next = p2;
        }
        return head.next;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
