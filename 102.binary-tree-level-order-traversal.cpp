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
        vector<vector<int>> ans;
        if (!root)
        {
            return ans;
        }

        queue<TreeNode *> lev;
        lev.push(root);

        while (!lev.empty())
        {
            vector<int> temp;
            int n = lev.size();
            for (int i = 0; i < n; i++)
            {
                temp.push_back(lev.front()->val);
                if (lev.front()->left)
                    lev.push(lev.front()->left);
                if (lev.front()->right)
                    lev.push(lev.front()->right);

                lev.pop();
            }
            ans.push_back(temp);
        }

        return ans;
    }
};
// @lc code=end
