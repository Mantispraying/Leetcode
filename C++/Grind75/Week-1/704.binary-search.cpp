#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=704 lang=cpp
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        if (nums.size() == 0)
        {
            return -1;
        }

        int l = 0, r = nums.size() - 1;

        while (l <= r)
        {
            int m = l + (r - l) / 2;

            if (nums[m] < target)
            {
                l = m + 1;
            }
            else if (nums[m] > target)
            {
                r = m - 1;
            }
            else
            {
                return m;
            }
        }
        return -1;
    }
};
// @lc code=end