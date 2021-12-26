package com.dsalgo;

//https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
public class CloneLL {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.random = head.next.next.next;
        head.next.random = head;
        head.next.next.next.random = head.next;
        Node result = cloneLL(head);
        printLL(result);

    }

    private static void printLL(Node result) {

        Node head  = result;

        while(head != null){
            System.out.println("Node value:" + head.val);
            if(head.next != null){
                System.out.println("Node next:" + head.next.val);
            }else{
                System.out.println("Node next is null");
            }

            if(head.random != null){
                System.out.println("Node random:" + head.random.val);
            }else{
                System.out.println("Node random is null");
            }

            head = head.next;
        }
    }

    private static Node cloneLL(Node head) {

        Node iter = head;
        Node front = head;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy = pseudoHead;

        while (iter != null) {
            front = iter.next.next;
            // extract the copy
            copy.next = iter.next;
            copy = copy.next;

            // restore the original list
            iter.next = front;

            iter = front;
        }

        return pseudoHead.next;

    }


    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }
}
