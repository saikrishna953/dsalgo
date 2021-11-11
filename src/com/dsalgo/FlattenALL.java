package com.dsalgo;

public class FlattenALL {

    Node head;

    class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    Node push(Node head_ref, int data) {
        Node new_node = new Node(data);

        new_node.down = head_ref;

        head_ref = new_node;

        return head_ref;
    }

    public static void main(String args[]) {
        FlattenALL L = new FlattenALL();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 20);

        // flatten the list
        L.head = L.flatten(L.head);

        L.printList();
    }

    private Node flatten(Node head) {

        if (head == null || head.right == null) {
            return head;
        }

        head.right = flatten(head.right);
        head = mergeTwoLL(head, head.right);

        return head;

    }

    private Node mergeTwoLL(Node l1, Node l2) {

        Node temp = new Node(0);
       Node res = temp;

       while(l1 != null && l2 != null){
           if(l1.data < l2.data){
               temp.down = l1;
               l1 = l1.down;
           }else{
               temp.down = l2;
               l2 = l2.down;
           }
           temp = temp.down;
       }

       if(l1 != null){
           temp.down = l1;
       }else{
           temp.down = l2;
       }

       return res.down;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }
}
