package com.dsalgo;

//https://leetcode.com/problems/linked-list-cycle-ii/
//o(n)-time complexity
//https://www.youtube.com/watch?v=QfbOhn0WZ88&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=36
public class StartingPointInCycleOfLL {
    public static void main(String[] args) {

        Node linkedListNode1 = new Node(1);
        linkedListNode1.next = new Node(2);
        linkedListNode1.next.next = new Node(8);
        linkedListNode1.next.next.next = new Node(7);
        linkedListNode1.next.next.next.next = new Node(6);
        linkedListNode1.next.next.next.next.next = linkedListNode1.next.next;

        Node result = getStartingPointOfCycle(linkedListNode1);
        System.out.println("Starting point in a cycle:" + result.val);

    }

    private static Node getStartingPointOfCycle(Node linkedListNode1) {
        if (linkedListNode1 == null || linkedListNode1.next == null) {
            return null;
        }

        Node slow = linkedListNode1;
        Node fast = linkedListNode1;
        Node entry = linkedListNode1;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }

        return null;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
