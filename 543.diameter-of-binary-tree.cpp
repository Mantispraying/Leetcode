#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=543 lang=cpp
 *
 * [543] Diameter of Binary Tree
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
private:
    int checkDepth(TreeNode *root, int &diameter)
    {
        if (!root)
        {
            return 0;
        }

        int left = checkDepth(root->left, diameter);
        int right = checkDepth(root->right, diameter);

        if (left + right > diameter)
            diameter = abs(left + right);
        return max(left, right) + 1;
    }

public:
    int diameterOfBinaryTree(TreeNode *root)
    {
        int diameter = 0;
        checkDepth(root, diameter);
        return diameter;
    }
};
// @lc code=end
