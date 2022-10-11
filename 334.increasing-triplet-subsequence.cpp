#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=334 lang=cpp
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution
{
public:
    bool increasingTriplet(vector<int> &nums)
    {
        if (nums.size() == 0 || nums.size() == 1)
        {
            return false;
        }

        int first = nums[0], second = INT_MAX;

        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] < first)
            {
                first = nums[i];
            }
            else if (nums[i] > first && nums[i] < second)
            {
                second = nums[i];
            }
            else if (nums[i] > second)
            {
                return true;
            }
        }

        return false;
    }
};
// @lc code=end
