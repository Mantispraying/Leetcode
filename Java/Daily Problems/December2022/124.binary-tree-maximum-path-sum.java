package December2022;

/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    private int maxPathSum;

    public int maxTreeSum(TreeNode root) {
        if (root == null)
            return 0;
        int leftPath = Math.max(0, maxTreeSum(root.left));
        int rightPath = Math.max(0, maxTreeSum(root.right));
        maxPathSum = Math.max(maxPathSum, leftPath + rightPath + root.val);
        return root.val + Math.max(leftPath, rightPath);
    }

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        maxTreeSum(root);
        return maxPathSum;
    }
}
// @lc code=end
