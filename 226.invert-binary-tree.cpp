#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=226 lang=cpp
 *
 * [226] Invert Binary Tree
 */
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution
{
public:
    void invertNode(TreeNode *root)
    {
        if (!root)
        {
            return;
        }
        invertNode(root->left);
        invertNode(root->right);
        TreeNode *temp = root->left;
        root->left = root->right;
        root->right = temp;
    }

    TreeNode *invertTree(TreeNode *root)
    {
        invertNode(root);
        return root;
    }
};
// @lc code=end