package February2023;

/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int minDiff = Integer.MAX_VALUE;
    TreeNode prev;

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (prev != null)
            minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inOrder(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
}
// @lc code=end