package Grind75.Week1;

/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    private int treeHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = treeHeight(root.left), right = treeHeight(root.right);
        if (left != -1 && right != -1 && Math.abs(right - left) < 2)
            return Math.max(left, right) + 1;
        return -1;
    }

    public boolean isBalanced(TreeNode root) {
        if (treeHeight(root) == -1)
            return false;
        return true;
    }
}
// @lc code=end
