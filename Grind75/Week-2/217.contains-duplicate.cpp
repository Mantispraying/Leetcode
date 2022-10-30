#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=217 lang=cpp
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution
{
public:
    bool containsDuplicate(vector<int> &nums)
    {
        unordered_set<int> st;

        for (int i = 0; i < nums.size(); i++)
        {
            if (st.find(nums[i]) != st.end())
            {
                return true;
            }
            st.insert(nums[i]);
        }
        return false;
    }
};
// @lc code=end
