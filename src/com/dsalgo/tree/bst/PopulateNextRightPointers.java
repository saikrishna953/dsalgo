package com.dsalgo.tree.bst;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulateNextRightPointers {

    public static void main(String[] args) {
        PopulateNextRightPointers p = new PopulateNextRightPointers();
        p.execute();
    }

    private void execute() {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
        a.right.left = new Node(6);
        a.right.right = new Node(7);

        populateNextPointer(a);
        print2DUtil(a, 0);
    }

    static void print2DUtil(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        if (root.next != null) {
            System.out.print(root.val + ",Next-" + root.next.val + "\n");
        } else {
            System.out.print(root.val + "\n");
        }


        // Process left child
        print2DUtil(root.left, space);
    }

    private void populateNextPointer(Node a) {

        Node curr = a;
        while (curr != null) {
            Node head = curr;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }

                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            curr = head.left;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
