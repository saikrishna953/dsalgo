package com.dsalgo;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        Node linkedListNode1 = new Node(3);
        linkedListNode1.next = new Node(4);
        linkedListNode1.next.next = new Node(8);
        linkedListNode1.next.next.next = new Node(10);

        Node linkedListNode2 = new Node(5);
        linkedListNode2.next = new Node(7);
        linkedListNode2.next.next = new Node(9);

        Node mergedList = merge(linkedListNode1, linkedListNode2);
        ;
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
        if (l1.val > l2.val) {
            Node tmp = l2;
            l2 = l1;
            l1 = tmp;
        }
        Node res = l1;
        while ((l1.next != null) && (l2.next != null)) {
            Node tmp = null;
            while ((l1 != null) && (l1.val <= l2.val)) {
                tmp = l1;
                l1 = l1.next;
            }
            tmp.next = l2;
            Node swap = l2;
            l2 = l1;
            l1 = swap;
        }
        return res;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
