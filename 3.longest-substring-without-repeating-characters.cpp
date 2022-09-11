#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        unordered_map<char, int> cmp;
        int l = 0, r = 0, ans = 0;
        while (r < s.size())
        {
            if (cmp.find(s[r]) != cmp.end())
            {
                l = max(l, cmp[s[r]] + 1);
            }
            cmp[s[r]] = r;
            ans = max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
};
// @lc code=end