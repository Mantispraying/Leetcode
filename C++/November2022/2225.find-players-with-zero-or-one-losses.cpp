#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=2225 lang=cpp
 *
 * [2225] Find Players With Zero or One Losses
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> findWinners(vector<vector<int>> &matches)
    {
        map<int, int> mp;
        vector<vector<int>> ans(2);
        for (auto it : matches)
        {
            if (mp.count(it[0]) == 0)
            {
                mp[it[0]] = 0;
            }
            mp[it[1]]++;
        }

        for (auto it = mp.begin(); it != mp.end(); it++)
        {
            if (it->second == 0)
            {
                ans[0].push_back(it->first);
            }
            else if (it->second == 1)
            {
                ans[1].push_back(it->first);
            }
        }
        return ans;
    }
};
// @lc code=end
