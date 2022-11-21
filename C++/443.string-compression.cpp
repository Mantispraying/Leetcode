#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=443 lang=cpp
 *
 * [443] String Compression
 */

// @lc code=start
class Solution
{
public:
    int compress(vector<char> &chars)
    {
        int idx = 0, i = 0;

        while (i < chars.size())
        {
            int j = i;

            while (j < chars.size() && chars[j] == chars[i])
            {
                j++;
            }

            chars[idx++] = chars[i];

            int occ = j - i;
            if (occ > 1)
            {
                string str = to_string(occ);
                for (char c : str)
                {
                    chars[idx++] = c;
                }
            }
            i = j;
        }
        return idx;
    }
};
// @lc code=end
