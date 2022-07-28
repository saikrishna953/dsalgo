package com.dsalgo.tree;

public class MaxPathSum {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathSum(node, maxValue);
        System.out.println(maxValue[0]);
    }

    private static int maxPathSum(TreeNode node, int[] maxValue) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSum(node.left, maxValue));
        int right = Math.max(0, maxPathSum(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.val);

        return node.val + Math.max(left, right);
    }
}
