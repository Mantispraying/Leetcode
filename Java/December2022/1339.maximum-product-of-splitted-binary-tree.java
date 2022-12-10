package December2022;

/*
 * @lc app=leetcode id=1339 lang=java
 *
 * [1339] Maximum Product of Splitted Binary Tree
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
    long totalSum = 0, ans;

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        ans = Math.max(ans, sum * (totalSum - sum));
        return sum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = dfs(root);
        dfs(root);
        return (int) (ans % (1e9 + 7));
    }
}
// @lc code=end
