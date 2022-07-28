package com.dsalgo.tree;

public class IsMirror {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);

        b.left = new TreeNode(3);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(5);
        b.right.right = new TreeNode(4);
        System.out.println(checkIfTwoTreesAreMirrors(a, b));
    }

    private static boolean checkIfTwoTreesAreMirrors(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return (a.val == b.val) && checkIfTwoTreesAreMirrors(a.left, b.right)
                && checkIfTwoTreesAreMirrors(a.right, b.left);

    }
}
