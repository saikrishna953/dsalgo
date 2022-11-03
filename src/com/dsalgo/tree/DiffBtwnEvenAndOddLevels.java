package com.dsalgo.tree;


import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels
//tc-O(n)
public class DiffBtwnEvenAndOddLevels {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int result = getDiffOfOddAndEvenNodes(root);
        System.out.print(result);
    }

    static class Node {
        Node left;
        Node right;
        int val;

        Node(int v) {
            this.val = v;
        }
    }

    static public int getDiffOfOddAndEvenNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return root.val - getDiffOfOddAndEvenNodes(root.left) - getDiffOfOddAndEvenNodes(root.right);
    }

    static int evenOddLevelDifference(Node root)
    {
        if (root == null)
            return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        int evenSum = 0, oddSum = 0;

        while (q.size() != 0) {
            int size = q.size();
            level++;

            while (size > 0) {
                Node temp = q.remove();

                if (level % 2 == 0)
                    evenSum += temp.val;
                else
                    oddSum += temp.val;

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
                size--;
            }
        }
        return (oddSum - evenSum);
    }

}
