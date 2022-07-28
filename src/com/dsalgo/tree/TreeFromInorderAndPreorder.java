package com.dsalgo.tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFromInorderAndPreorder {
    static final int COUNT = 10;

    public static void main(String[] args) {
        int preorder[] = {10, 20, 40, 50, 30, 60};
        int inorder[] = {40, 20, 50, 10, 60, 30};
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, inorder, 0,
                preorder.length - 1, 0, inorder.length - 1, hashMap);
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

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd
            , int inStart, int inEnd, Map<Integer, Integer> hashMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = hashMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1, hashMap);
        root.right = buildTree(preorder, inorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd, hashMap);
        return root;

    }
}
