#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=125 lang=cpp
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution
{
public:
    bool isPalindrome(string s)
    {
        string x;
        for (int i = 0; i < s.size(); i++)
        {
            if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z') || (s[i] >= '0' && s[i] <= '9'))
            {
                x += tolower(s[i]);
            }
        }
        string y = x;
        reverse(x.begin(), x.end());
        return x == y;
    }
};
// @lc code=end
