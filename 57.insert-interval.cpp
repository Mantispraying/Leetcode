#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=57 lang=cpp
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> insert(vector<vector<int>> &intervals, vector<int> &newInterval)
    {
        vector<vector<int>> ans;
        for (int i = 0; i < intervals.size(); i++)
        {
            if (newInterval[1] < intervals[i][0])
            {
                ans.push_back(newInterval);
                ans.insert(ans.end(), intervals.begin() + i, intervals.end());
                return ans;
            }
            else if (newInterval[0] > intervals[i][1])
            {
                ans.push_back(intervals[i]);
            }
            else
            {
                newInterval = {min(newInterval[0], intervals[i][0]), max(newInterval[1], intervals[i][1])};
            }
        }
        ans.push_back(newInterval);
        return ans;
    }
};
// @lc code=end
