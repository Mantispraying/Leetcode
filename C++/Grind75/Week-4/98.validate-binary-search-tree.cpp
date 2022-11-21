#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=98 lang=cpp
 *
 * [98] Validate Binary Search Tree
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
    bool validateNode(TreeNode *root, TreeNode *low, TreeNode *high)
    {
        if (root == nullptr)
        {
            return true;
        }
        if ((low != nullptr && root->val <= low->val) || (high != nullptr && root->val >= high->val))
        {
            return false;
        }
        return validateNode(root->left, low, root) && validateNode(root->right, root, high);
    }

    bool isValidBST(TreeNode *root)
    {
        if (!root)
        {
            return true;
        }
        return validateNode(root, nullptr, nullptr);
    }
};
// @lc code=end
