package com.dsalgo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//left root right
public class InOrderTraversal {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);
        List<Integer> recur = new ArrayList<>();
        inOrderRecursion(node, recur);
        List<Integer> iter = inOrderIterator(node);
        recur.forEach(System.out::println);
        System.out.println("--------------");
        iter.forEach(System.out::println);
    }

    private static List<Integer> inOrderIterator(TreeNode node) {
        List<Integer> iter = new ArrayList<>();
        if (node == null) {
            return iter;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = node;
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                iter.add(root.val);
                root = root.right;
            }
        }
        return iter;
    }

    private static void inOrderRecursion(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderRecursion(node.left, result);
        result.add(node.val);
        inOrderRecursion(node.right, result);
    }

}
