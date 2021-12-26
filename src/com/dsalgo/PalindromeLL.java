package com.dsalgo;

public class PalindromeLL {

    public static void main(String[] args) {
        Node linkedListNode1 = new Node(1);
        linkedListNode1.next = new Node(2);
        linkedListNode1.next.next = new Node(3);
        linkedListNode1.next.next.next = new Node(3);
        linkedListNode1.next.next.next.next = new Node(2);
        linkedListNode1.next.next.next.next.next = new Node(1);
        boolean res = isPalindrome(linkedListNode1);
        System.out.println("isPalindrome:" + res);
    }

    private static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = reverseLL(slow.next);
        slow = slow.next;

        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    private static Node reverseLL(Node head) {
        Node newHead = null;
        while(head != null){
            Node nex = head.next;
            head.next = newHead;
            newHead = head;
            head = nex;
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
