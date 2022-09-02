#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=70 lang=cpp
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution
{
public:
    int count(int n, vector<int> &dp)
    {
        if (n < 3)
        {
            return n;
        }

        if (dp[n] != -1)
        {
            return dp[n];
        }
        return dp[n] = count(n - 1, dp) + count(n - 2, dp);
    }

    int climbStairs(int n)
    {
        vector<int> dp(n + 1, -1);
        return count(n, dp);

        // int a = 1, b = 1;

        // for (int i = 2; i <= n; i++)
        // {
        //     a = a + b;
        //     b = a - b;
        // }
        // return a;
    }
};
// @lc code=end