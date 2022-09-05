#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=104 lang=cpp
 *
 * [104] Maximum Depth of Binary Tree
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
    int maxDepth(TreeNode *root)
    {
        int depth = 0;

        if (root == NULL)
            return depth;

        queue<TreeNode *> q;

        q.push(root);

        while (!q.empty())
        {

            int size = q.size();

            depth++;

            for (int i = 0; i < size; i++)
            {

                TreeNode *temp = q.front();

                q.pop();

                if (temp->left != NULL)
                    q.push(temp->left);

                if (temp->right != NULL)
                    q.push(temp->right);
            }
        }

        return depth;

        // if (!root)
        // {
        //     return 0;
        // }
        // int left = maxDepth(root->left);
        // int right = maxDepth(root->right);

        // return max(left, right) + 1;
    }
};
// @lc code=end
