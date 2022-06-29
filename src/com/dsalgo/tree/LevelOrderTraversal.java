package com.dsalgo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);
        List<Integer> iter = levelOrderTraversal(node);
        iter.forEach(System.out::println);
    }

    private static List<Integer> levelOrderTraversal(TreeNode node) {
        List<Integer> iter = new ArrayList<>();
        if (node == null) {
            return iter;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = node;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode g = queue.poll();
            if (g.left != null) {
                queue.offer(g.left);
            }

            if (g.right != null) {
                queue.offer(g.right);
            }

            iter.add(g.val);
        }
        return iter;
    }
}
