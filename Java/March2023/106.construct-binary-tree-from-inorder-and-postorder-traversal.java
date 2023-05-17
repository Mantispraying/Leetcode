package March2023;

import java.util.*;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd,
            Map<Integer, Integer> inMap) {
        if (posStart > posEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[posEnd]);
        int rootIdx = inMap.get(root.val);
        int numLeft = rootIdx - inStart;
        root.left = helper(inorder, inStart, rootIdx - 1, postorder, posStart, posStart + numLeft - 1, inMap);
        root.right = helper(inorder, rootIdx + 1, inEnd, postorder, posStart + numLeft, posEnd - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }
}
// @lc code=end