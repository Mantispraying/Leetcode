#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=121 lang=cpp
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int maxd = 0;
        int minp = INT_MAX;

        for (int i = 0; i < prices.size(); i++)
        {
            if (prices[i] < minp)
            {
                minp = prices[i];
            }
            else if (prices[i] - minp > maxd)
            {
                maxd = prices[i] - minp;
            }
        }
        return maxd;
    }
};
// @lc code=end