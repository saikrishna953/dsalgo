package com.dsalgo;

//https://leetcode.com/problems/rotate-list/description/
public class RotateLL {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Node linkedListNode1 = new Node(1);
        linkedListNode1.next = new Node(2);
        linkedListNode1.next.next = new Node(8);
        linkedListNode1.next.next.next = new Node(7);
        linkedListNode1.next.next.next.next = new Node(6);
        linkedListNode1.next.next.next.next.next = new Node(10);

        System.out.println("Before rotation");
        printLL(linkedListNode1);
        System.out.println();
        System.out.println("After rotation");
        Node res = rotateLL(linkedListNode1,2);
        printLL(res);
    }

    private static Node rotateLL(Node head, int k) {
        if(head == null || head.next == null || k==1){
            return head;
        }

        Node cur = head;
        int len = 1;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        cur.next = head;
        k = k % len;
        k = len - k;
        while(k-- > 0){
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;

        return head;
    }

    private static void printLL(Node linkedListNode1) {

        while (linkedListNode1 != null) {
            System.out.print(linkedListNode1.val + " ");
            linkedListNode1 = linkedListNode1.next;
        }
    }
}
