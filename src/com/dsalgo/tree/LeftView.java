package com.dsalgo.tree;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(6);
        node.left.right.right = new TreeNode(7);

        List<Integer> iter = leftSideView(node);
        System.out.println("--------------");
        iter.forEach(System.out::println);
    }

    private static List<Integer> leftSideView(TreeNode node) {
        List<Integer> iter = new ArrayList<>();
        leftView(node,iter,0);
        return iter;
    }

    private static void leftView(TreeNode node, List<Integer> result, int currDepth) {
        if (node == null) {
            return;
        }
        if(currDepth == result.size()){
            result.add(node.val);
        }
        leftView(node.left, result,currDepth+1);
        leftView(node.right, result,currDepth+1);
    }

}
