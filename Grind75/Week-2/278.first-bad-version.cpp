#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=278 lang=cpp
 *
 * [278] First Bad Version
 */
bool isBadVersion(int version);
// @lc code=start
// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution
{
public:
    int firstBadVersion(int n)
    {
        int l = 1, r = n, b = n, m;

        while (r >= l)
        {
            m = l + (r - l) / 2;

            if (isBadVersion(m))
            {
                r = m - 1;
                b = m;
            }
            else
            {
                l = m + 1;
            }
        }
        return b;
    }
};
// @lc code=end
