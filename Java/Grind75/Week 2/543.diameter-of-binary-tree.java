import java.util.*;

/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        armLength(root);
        return ans;
    }

    private int armLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = armLength(root.left);
        int right = armLength(root.right);
        ans = Math.max(left + right, ans);
        return Math.max(left, right) + 1;
    }
}
// @lc code=end
