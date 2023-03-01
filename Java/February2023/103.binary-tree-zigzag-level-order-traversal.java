package February2023;

import java.util.*;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode curr = s1.pop();
                level.add(curr.val);
                if (curr.left != null)
                    s2.add(curr.left);
                if (curr.right != null)
                    s2.add(curr.right);
            }
            if (!level.isEmpty())
                ans.add(level);
            level = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode curr = s2.pop();
                level.add(curr.val);
                if (curr.right != null)
                    s1.add(curr.right);
                if (curr.left != null)
                    s1.add(curr.left);
            }
            if (!level.isEmpty())
                ans.add(level);
        }
        return ans;
    }
}
// @lc code=end