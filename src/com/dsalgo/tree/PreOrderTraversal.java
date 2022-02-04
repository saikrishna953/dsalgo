package com.dsalgo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//root left right
public class PreOrderTraversal {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);
        List<Integer> recur = new ArrayList<>();
        preOrderRecursion(node, recur);
        List<Integer> iter = preOrderIterator(node);
        recur.forEach(System.out::println);
        System.out.println("--------------");
        iter.forEach(System.out::println);
    }

    private static List<Integer> preOrderIterator(TreeNode node) {
        List<Integer> iter = new ArrayList<>();
        if (node == null) {
            return iter;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = node;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            iter.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return iter;
    }

    private static void preOrderRecursion(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preOrderRecursion(node.left, result);
        preOrderRecursion(node.right, result);
    }

}
