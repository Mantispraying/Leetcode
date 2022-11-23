#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1047 lang=cpp
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution
{
public:
    string removeDuplicates(string s)
    {
        int curr = -1;
        for (int i = 0; i < s.size(); i++)
        {
            if (curr >= 0 && s[curr] == s[i])
            {
                curr--;
            }
            else
            {
                s[++curr] = s[i];
            }
        }
        return s.substr(0, curr + 1);
    }
};
// @lc code=end
int main()
{
    Solution sol;
    sol.removeDuplicates("abbaca");
    return 0;
}