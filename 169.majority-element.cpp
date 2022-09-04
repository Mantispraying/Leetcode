#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=169 lang=cpp
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution
{
public:
    int majorityElement(vector<int> &nums)
    {
        int ele = 0;
        int count = 0;

        for (int i = 0; i < nums.size(); i++)
        {
            if (!count)
            {
                ele = nums[i];
                count++;
            }
            else if (ele == nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return ele;
    }
};
// @lc code=end
