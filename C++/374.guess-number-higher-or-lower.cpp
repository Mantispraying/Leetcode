#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=374 lang=cpp
 *
 * [374] Guess Number Higher or Lower
 */
int guess(int num)
{
    return 0;
}
// @lc code=start
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution
{
public:
    int guessNumber(int n)
    {
        int l = 0, r = n, m;
        while (l <= r)
        {
            m = ((r - l) / 2) + l;
            int res = guess(m);
            if (res == -1)
            {
                r = m - 1;
            }
            else if (res == 1)
            {
                l = m + 1;
            }
            else
            {
                return m;
            }
        }
        return -1;
    }
};
// @lc code=end
