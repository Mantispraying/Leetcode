#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=102 lang=cpp
 *
 * [102] Binary Tree Level Order Traversal
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
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        if (!root)
        {
            return {};
        }

        vector<vector<int>> ans;
        ans.push_back({root->val});
        queue<TreeNode *> curr;
        curr.push(root);
        vector<int> vals;

        while (!curr.empty())
        {
            queue<TreeNode *> temp;
            vals.clear();
            while (!curr.empty())
            {
                if (curr.front()->left)
                {
                    temp.push(curr.front()->left);
                    vals.push_back(curr.front()->left->val);
                }
                if (curr.front()->right)
                {
                    temp.push(curr.front()->right);
                    vals.push_back(curr.front()->right->val);
                }
                curr.pop();
            }
            if (!vals.empty())
            {
                ans.push_back(vals);
            }
            curr = temp;
        }
        return ans;
    }
};
// @lc code=end
