package com.dsalgo.tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFromInorderAndPostorder {
    static final int COUNT = 10;

    public static void main(String[] args) {
        int postorder[] = {40, 50, 20, 60, 30, 10};
        int inorder[] = {40, 20, 50, 10, 60, 30};
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(postorder, inorder, 0,
                postorder.length - 1, 0, inorder.length - 1, hashMap);
        print2DUtil(root, 0);
    }

    static void print2DUtil(TreeNode root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    private static TreeNode buildTree(int[] postorder, int[] inorder, int postStart, int postEnd
            , int inStart, int inEnd, Map<Integer, Integer> hashMap) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = hashMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(postorder, inorder, postStart, postStart + numsLeft - 1, inStart, inRoot - 1, hashMap);
        root.right = buildTree(postorder, inorder, postStart + numsLeft, postEnd - 1, inRoot + 1, inEnd, hashMap);
        return root;

    }
}
