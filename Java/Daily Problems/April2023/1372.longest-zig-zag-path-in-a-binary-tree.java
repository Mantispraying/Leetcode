package April2023;

/*
 * @lc app=leetcode id=1372 lang=java
 *
 * [1372] Longest ZigZag Path in a Binary Tree
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
    int maxPath = 0;

    private int longestZigZag(boolean dir, TreeNode root) {
        if (root == null)
            return 0;
        int currMaxPath = 0;
        if (dir) {
            currMaxPath = longestZigZag(false, root.right) + 1;
            longestZigZag(true, root.left);
        } else {
            currMaxPath = longestZigZag(true, root.left) + 1;
            longestZigZag(false, root.right);
        }
        maxPath = Math.max(maxPath, currMaxPath);
        return currMaxPath;
    }

    public int longestZigZag(TreeNode root) {
        longestZigZag(true, root.left);
        longestZigZag(false, root.right);
        return maxPath;
    }
}
// @lc code=end