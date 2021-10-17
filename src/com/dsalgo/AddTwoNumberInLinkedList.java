package com.dsalgo;

public class AddTwoNumberInLinkedList {
    public static void main(String[] args) {
        Node linkedListNode = new Node(2);
        linkedListNode.next = new Node(4);
        linkedListNode.next.next = new Node(3);

        Node linkedListNode1 = new Node(5);
        linkedListNode1.next = new Node(6);
        linkedListNode1.next.next = new Node(7);
        linkedListNode1.next.next.next = new Node(9);
        Node newHead = addTwoNumbers(linkedListNode, linkedListNode1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    private static Node addTwoNumbers(Node l1, Node l2) {
        Node result = new Node();
        Node tmp = result;
        int sum = 0, c = 0;
        while (l1 != null || l2 != null || c == 1) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += c;
            c = sum / 10;
            Node listNode = new Node(sum % 10);
            tmp.next = listNode;
            tmp = tmp.next;

        }
        return result.next;
    }

    static class Node {
        int val;
        Node next;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }
    }
}
