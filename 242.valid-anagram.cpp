#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=242 lang=cpp
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution
{
public:
    bool isAnagram(string s, string t)
    {
        if (s.size() != t.size())
        {
            return false;
        }

        unordered_map<char, int> umap1;
        unordered_map<char, int> umap2;

        for (int i = 0; i < s.size(); i++)
        {
            umap1[s[i]]++;
            umap2[t[i]]++;
        }
        

        return umap1 == umap2;
    }
};
// @lc code=end
