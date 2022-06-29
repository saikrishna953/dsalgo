package com.dsalgo.tree;

public class BalancedTree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);
        System.out.println(isBalanced(node));
    }

    private static boolean isBalanced(TreeNode node) {

        return (dfsHeight(node) != -1);
    }

    private static int dfsHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = dfsHeight(node.left);
        if (lh == -1) return -1;
        int rh = dfsHeight(node.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) {
            return -1;
        } else {
            return 1 + Math.max(lh, rh);
        }
    }
}
