#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=973 lang=cpp
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> kClosest(vector<vector<int>> &points, int k)
    {
        int x, y;
        vector<vector<int>> ans;
        priority_queue<vector<int>> pq;

        for (auto point : points)
        {
            x = point[0];
            y = point[1];
            pq.push({-((x * x) + (y * y)), x, y});
        }

        while (k--)
        {
            ans.push_back({pq.top()[1], pq.top()[2]});
            pq.pop();
        }

        return ans;
    }
};
// @lc code=end
