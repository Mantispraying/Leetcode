#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=263 lang=cpp
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution
{
public:
    bool isUgly(int n)
    {
        if (n <= 0)
            return false;

        for (int fact : {2, 3, 5})
        {
            while (n % fact == 0)
            {
                n /= fact;
            }
        }
        return n == 1;
    }
};
// @lc code=end
