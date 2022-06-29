package com.dsalgo.tree;

//tc-O(N)
//sc-O(N)
public class LCA {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);
        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(9);
        System.out.println(lca(node, node.left.left, node.left.right.right).val);
    }

    private static TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {

        if ((node == null) || (node == p) || (node == q)) {
            return node;
        }
        TreeNode left = lca(node.left, p, q);
        TreeNode right = lca(node.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return node;
        }
    }
}
