package com.dsalgo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//tc-O(N)
//sc-O(N)
public class ZigZagTraversal {
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

        ArrayList<ArrayList<Integer>> result = zigzaglevelordertraversal(node);

        result.forEach(integers -> integers.forEach(System.out::println));
    }

    private static ArrayList<ArrayList<Integer>> zigzaglevelordertraversal(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        queue.offer(node);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int noOfItems = queue.size();
            ArrayList<Integer> sublist = new ArrayList<>(noOfItems);
            for (int i = 0; i < noOfItems; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                if (flag) {
                    sublist.add(queue.poll().val);
                } else {
                    sublist.add(0, queue.poll().val);
                }
            }
            flag = !flag;
            result.add(sublist);
        }
        return result;
    }
}
