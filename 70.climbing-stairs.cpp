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
    vector<vector<int>> matrixMultiply(vector<vector<int>> &a, vector<vector<int>> &b)
    {
        vector<vector<int>> ans(a.size(), vector<int>(a.size()));

        for (int i = 0; i < a.size(); i++)
        {
            for (int j = 0; j < a.size(); j++)
            {
                for (int k = 0; k < a.size(); k++)
                {
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }

    vector<vector<int>> matrixExpo(vector<vector<int>> &a, int n)
    {
        if (n == 0)
        {
            return {{1, 0}, {0, 1}};
        }
        if (n == 1)
        {
            return a;
        }

        vector<vector<int>> temp = matrixExpo(a, n / 2);
        temp = matrixMultiply(temp, temp);

        if (n % 2)
        {
            return matrixMultiply(temp, a);
        }
        return temp;
    }

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

        // matrix exponentiation
        vector<vector<int>> a = {{1, 1}, {1, 0}};
        vector<vector<int>> ans = matrixExpo(a, n);

        return ans[0][0];

        // Recursive Memoization
        // vector<int> dp(n + 1, -1);
        // return count(n, dp);

        // Iterative tabulation
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