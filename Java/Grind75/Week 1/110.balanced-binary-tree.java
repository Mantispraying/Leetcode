import java.util.*;

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

    public boolean isBalanced(TreeNode root) {
        int ans = checkHeight(root);
        return ans != -1;
    }

    int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = checkHeight(root.left);
        int right = checkHeight(root.right);
        if ((Math.abs(right - left) > 1) || left == -1 || right == -1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
// @lc code=end
