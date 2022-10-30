#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1832 lang=cpp
 *
 * [1832] Check if the Sentence Is Pangram
 */

// @lc code=start
class Solution
{
public:
    bool checkIfPangram(string sentence)
    {
        vector<bool> occ(26, false);
        for (char ch : sentence)
        {
            occ[ch - 'a'] = true;
        }

        for (int i = 0; i < 26; i++)
        {
            if (!occ[i])
            {
                return false;
            }
        }

        return true;
    }
};
// @lc code=end
