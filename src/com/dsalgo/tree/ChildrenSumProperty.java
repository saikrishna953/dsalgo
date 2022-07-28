package com.dsalgo.tree;

//tc-O(N)
//sc-O(N)
public class ChildrenSumProperty {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(35);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);

        changeTree(root);
        print2DUtil(root, 0);
    }

    static void print2DUtil(TreeNode root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    private static void changeTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int child = 0;

        if (root.left != null) {
            child += root.left.val;
        }

        if (root.right != null) {
            child += root.right.val;
        }
        if (child < root.val) {
            if (root.left != null) {
                root.left.val = root.val;
            }
            if (root.right != null) {
                root.right.val = root.val;
            }
        } else {
            root.val = child;
        }
        changeTree(root.left);
        changeTree(root.right);
        int tot = 0;
        if (root.left != null) {
            tot += root.left.val;
        }
        if (root.right != null) {
            tot += root.right.val;
        }
        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }
}
