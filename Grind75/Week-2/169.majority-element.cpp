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
        int ele = nums[0];
        int count = 1;

        for (int i = 1; i < nums.size(); i++)
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
            else if (count > nums.size() / 2)
            {
                return ele;
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
