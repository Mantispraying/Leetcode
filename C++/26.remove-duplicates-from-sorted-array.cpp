#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=26 lang=cpp
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution
{
public:
    int removeDuplicates(vector<int> &nums)
    {
        int curr = 0, n = nums.size();

        for (int i = 0; i < n; i++)
        {
            if (nums[i] != nums[curr])
            {
                nums[++curr] = nums[i];
            }
        }
        return curr + 1;
    }
};
// @lc code=end
