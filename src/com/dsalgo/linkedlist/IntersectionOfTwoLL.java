package com.dsalgo.linkedlist;

public class IntersectionOfTwoLL {
    public static void main(String[] args) {
        Node linkedListNode1 = new Node(1);
        /*linkedListNode1.next = new Node(2);
        linkedListNode1.next.next = new Node(8);
        linkedListNode1.next.next.next = new Node(7);
        linkedListNode1.next.next.next.next = new Node(6);*/

        Node linkedListNode2 = linkedListNode1;
       /* Node linkedListNode2 = new Node(1);
       /* linkedListNode2.next = new Node(8);
        linkedListNode2.next.next = new Node(1);
        linkedListNode2.next.next.next = new Node(3);
        linkedListNode2.next.next.next.next = linkedListNode1.next.next;
        linkedListNode2.next.next.next.next.next = linkedListNode1.next.next.next;
        linkedListNode2.next.next.next.next.next.next = linkedListNode1.next.next.next.next;*/


        Node intersection = findIntersection(linkedListNode1, linkedListNode2);
        System.out.println(intersection.val);
    }

    private static Node findIntersection(Node head1, Node head2) {
        // Maintaining two pointers ptr1 and ptr2
        // at the head of A and B,
        Node ptr1 = head1;
        Node ptr2 = head2;

        // If any one of head is null i.e
        // no Intersection Point
        if (ptr1 == null || ptr2 == null) {

            return null;
        }

        // Traverse through the lists until they
        // reach Intersection node
        while (ptr1 != ptr2) {

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

            // If at any node ptr1 meets ptr2, then it is
            // intersection node.Return intersection node.

            if (ptr1 == ptr2) {

                return ptr1;
            }
        /* Once both of them go through reassigning,
        they will be equidistant from the collision point.*/

            // When ptr1 reaches the end of a list, then
            // reassign it to the head2.
            if (ptr1 == null) {

                ptr1 = head2;
            }
            // When ptr2 reaches the end of a list, then
            // redirect it to the head1.
            if (ptr2 == null) {

                ptr2 = head1;
            }
        }

        return ptr1;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
