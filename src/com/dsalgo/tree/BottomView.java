package com.dsalgo.tree;

import java.util.*;

public class BottomView {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(8);
        node.left.right.right = new TreeNode(9);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);

        List<Integer> iter = bottomView(node);
        System.out.println("--------------");
        iter.forEach(System.out::println);

    }

    private static List<Integer> bottomView(TreeNode root) {
        List<Integer> iter = new ArrayList<>();
        if (root == null) {
            return iter;
        }
        Map<Integer, Integer> m = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            m.put(temp.hd, temp.val);
            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                q.add(temp.right);

            }
        }
        for (Map.Entry<Integer, Integer> d : m.entrySet()
        ) {
            iter.add(d.getValue());

        }
        return iter;

    }
}
