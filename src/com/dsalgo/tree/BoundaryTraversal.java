package com.dsalgo.tree;

import java.util.ArrayList;

//anticlockwise
public class BoundaryTraversal {

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

        ArrayList<Integer> result = boundaryTraversal(node);
        result.forEach(System.out::println);
    }

    private static ArrayList<Integer> boundaryTraversal(TreeNode node) {

        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        if (isLeafNode(node)) {
            result.add(node.val);
            return result;
        }

        addLeftBoundaryNodes(node, result);
        addLeafs(node, result);
        addRightBoundaryNodes(node, result);

        return result;

    }

    private static void addRightBoundaryNodes(TreeNode node, ArrayList<Integer> result) {
        TreeNode curr = node;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (curr != null) {
            if (!isLeafNode(curr)) {
                tmp.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = tmp.size() - 1; i >= 0; i--) {
            result.add(tmp.get(i));
        }
    }

    private static void addLeafs(TreeNode node, ArrayList<Integer> result) {
        if (isLeafNode(node)) {
            result.add(node.val);
            return;
        }
        if (node.left != null) {
            addLeafs(node.left, result);
        }
        if (node.right != null) {
            addLeafs(node.right, result);
        }
    }

    private static void addLeftBoundaryNodes(TreeNode node, ArrayList<Integer> result) {
        TreeNode curr = node;

        while (curr != null) {
            if (!isLeafNode(curr)) {
                result.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static boolean isLeafNode(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }
}
