package com.dsalgo.tree;

public class SymmetricTree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(isSymmetric(node));
    }

    private static boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return true;
        } else {
            return isSymmetricUtil(node.left, node.right);
        }
    }

    private static boolean isSymmetricUtil(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return (left.val == right.val) && isSymmetricUtil(left.left, right.right)
                && isSymmetricUtil(left.right, right.left);
    }

}
