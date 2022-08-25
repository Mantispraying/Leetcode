#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=110 lang=cpp
 *
 * [110] Balanced Binary Tree
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
    int calcHeight(TreeNode *node)
    {
        if (!node)
        {
            return 0;
        }

        int l = calcHeight(node->left);
        if (l == -1)
        {
            return -1;
        }

        int r = calcHeight(node->right);
        if (r == -1)
        {
            return -1;
        }

        if (abs(l - r) > 1)
        {
            return -1;
        }

        return max(l, r) + 1;
    }

    bool isBalanced(TreeNode *root)
    {
        return calcHeight(root) != -1;
    }
};
// @lc code=end
