#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=31 lang=cpp
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution
{
public:
    void nextPermutation(vector<int> &nums)
    {
        int n = nums.size(), k, i;
        for (k = n - 2; k >= 0; k--)
        {
            if (nums[k] < nums[k + 1])
            {
                break;
            }
        }
        if (k < 0)
        {
            reverse(nums.begin(), nums.end());
        }
        else
        {
            for (i = n - 1; i > k; i--)
            {
                if (nums[k] < nums[i])
                {
                    break;
                }
            }
            swap(nums[k], nums[i]);
            reverse(nums.begin() + k + 1, nums.end());
        }
    }
};
// @lc code=end
