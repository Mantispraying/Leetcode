#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        int mxsum = INT_MIN, crsum = 0;
        for (auto &x : nums)
        {
            crsum += x;
            mxsum = max(mxsum, crsum);
            if (crsum < 0)
            {
                crsum = 0;
            }
        }
        return mxsum;
    }
};
// @lc code=end
