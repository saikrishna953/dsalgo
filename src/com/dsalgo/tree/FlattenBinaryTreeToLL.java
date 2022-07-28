package com.dsalgo.tree;

import java.util.Stack;

//preorder traversal output
public class FlattenBinaryTreeToLL {
    static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);
        //recursionflatten(node);
        //flatten(node);
        morrisTraversal(node);
        while (node.right != null) {
            System.out.println(node.val);
            node = node.right;
        }

    }

    //tc-O(N)
    //sc-O(1)
    private static void morrisTraversal(TreeNode node) {
        TreeNode curr = node;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    //tc-O(N)
    //sc-O(N)
    private static void flatten(TreeNode node) {

        if (node == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(node);
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
            if (!s.isEmpty()) {
                curr.right = s.peek();
            }
            curr.left = null;

        }

    }

    //tc-O(N)
    //sc-O(N)
    private static void recursionflatten(TreeNode node) {
        if (node == null) {
            return;
        }
        recursionflatten(node.right);
        recursionflatten(node.left);
        node.right = prev;
        node.left = null;
        prev = node;
    }
}
