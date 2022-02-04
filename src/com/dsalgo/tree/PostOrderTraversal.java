package com.dsalgo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//left right root
public class PostOrderTraversal {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);
        List<Integer> recur = new ArrayList<>();
        postOrderRecursion(node, recur);
        List<Integer> iter = postOrderIterator(node);
        recur.forEach(System.out::println);
        System.out.println("--------------");
        iter.forEach(System.out::println);
    }

    private static List<Integer> postOrderIterator(TreeNode node) {
        List<Integer> iter = new ArrayList<>();
        if (node == null) {
            return iter;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode root = node;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while (!stack2.isEmpty()){
            iter.add(stack2.pop().val);
        }
        return iter;
    }

    private static void postOrderRecursion(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postOrderRecursion(node.left, result);
        postOrderRecursion(node.right, result);
        result.add(node.val);
    }

}
