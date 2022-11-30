#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1207 lang=cpp
 *
 * [1207] Unique Number of Occurrences
 */

// @lc code=start
class Solution
{
public:
    bool uniqueOccurrences(vector<int> &arr)
    {
        unordered_set<int> freq_o;
        unordered_map<int, int> freq;

        for (int num : arr)
        {
            freq[num]++;
        }

        for (auto pr : freq)
        {
            if (!freq_o.emplace(pr.second).second)
                return false;
        }
        return true;
    }
};
// @lc code=end
