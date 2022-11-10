#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1544 lang=cpp
 *
 * [1544] Make The String Great
 */

// @lc code=start
class Solution
{
public:
    string makeGood(string s, int p = 0)
    {
        for (int i = 0; i < s.size(); i++)
        {
            if (p > 0 && abs(s[p - 1] - s[i]) == 32)
            {
                --p;
            }
            else
            {
                s[p++] = s[i];
            }
        }
        return s.substr(0, p);
    }
};
// @lc code=end
int main()
{
    Solution sol;
    sol.makeGood("abBAcC");
    return 0;
}