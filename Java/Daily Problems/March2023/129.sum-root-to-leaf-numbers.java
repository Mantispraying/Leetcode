package March2023;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    private int helper(TreeNode root, int sumTill) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null)
            return sumTill * 10 + root.val;
        return helper(root.left, sumTill * 10 + root.val) + helper(root.right, sumTill * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}
// @lc code=end