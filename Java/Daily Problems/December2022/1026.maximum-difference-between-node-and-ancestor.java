package December2022;

/*
 * @lc app=leetcode id=1026 lang=java
 *
 * [1026] Maximum Difference Between Node and Ancestor
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
    public int maxAncestorDiff(TreeNode root, int minNode, int maxNode) {
        if (root.val > maxNode)
            maxNode = root.val;
        if (root.val < minNode)
            minNode = root.val;
        int maxDiff = 0;
        if (root.left != null)
            maxDiff = Math.max(maxDiff, maxAncestorDiff(root.left, minNode, maxNode));
        if (root.right != null)
            maxDiff = Math.max(maxDiff, maxAncestorDiff(root.right, minNode, maxNode));
        return Math.max(maxDiff, maxNode - minNode);
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        int minNode = Integer.MAX_VALUE, maxNode = 0;
        return maxAncestorDiff(root, minNode, maxNode);
    }
}
// @lc code=end
