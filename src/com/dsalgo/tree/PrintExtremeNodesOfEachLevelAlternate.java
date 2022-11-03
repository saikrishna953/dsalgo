package com.dsalgo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintExtremeNodesOfEachLevelAlternate {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printExtremeNodes(root);
    }

    static class Node {
        Node left;
        Node right;
        int val;

        Node(int v) {
            this.val = v;
        }
    }

    static void printExtremeNodes(Node root)
    {
        if (root == null)
            return;

        // Create a queue and enqueue left and right
        // children of root
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // flag to indicate whether leftmost node or
        // the rightmost node has to be printed
        boolean flag = false;
        while (q.size()>0)
        {
            // nodeCount indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            int n = nodeCount;

            // Dequeue all nodes of current level
            // and Enqueue all nodes of next level
            while (n-- >0)
            {
                Node curr = q.peek();

                // Enqueue left child
                if (curr.left!=null)
                    q.add(curr.left);

                // Enqueue right child
                if (curr.right!=null)
                    q.add(curr.right);

                // Dequeue node
                q.remove();

                // if flag is true, print leftmost node
                if (flag && n == nodeCount - 1)
                    System.out.print( curr.val + " ");

                // if flag is false, print rightmost node
                if (!flag && n == 0)
                    System.out.print( curr.val + " ");

            }

            // invert flag for next level
            flag = !flag;
        }
    }

}
