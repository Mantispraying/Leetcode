#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=409 lang=cpp
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution
{
public:
    int longestPalindrome(string s)
    {
        unordered_map<char, int> count;
        int sum = 0;

        for (char x : s)
        {
            count[x]++;
        }

        for (auto it = count.begin(); it != count.end(); it++)
        {
            sum += (it->second / 2) * 2;

            if (it->second % 2 != 0 && sum % 2 == 0)
            {
                sum++;
            }
        }
        return sum;
    }
};
// @lc code=end
