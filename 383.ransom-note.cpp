#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=383 lang=cpp
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution
{
public:
    bool canConstruct(string ransomNote, string magazine)
    {
        if (magazine.size() < ransomNote.size())
        {
            return false;
        }

        unordered_map<char, int> ump;
        for (auto &letter : magazine)
        {
            ump[letter]++;
        }

        for (auto &letter : ransomNote)
        {
            if (ump[letter] == 0)
            {
                return false;
            }
            ump[letter]--;
        }
        return true;
    }
};
// @lc code=end
