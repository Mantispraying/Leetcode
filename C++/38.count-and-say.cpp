#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=38 lang=cpp
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution
{
public:
    string countAndSay(int n)
    {
        string ans = "";
        if (n == 1)
        {
            return "1";
        }
        string say = countAndSay(n - 1);
        int j = 0, i = 0;
        while (i < say.size())
        {
            while (say[j] == say[i] && j < say.size())
            {
                j++;
            }
            int diff = j - i;
            ans += to_string(diff);
            ans += say[i];
            i = j;
        }
        return ans;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    cout << sol.countAndSay(4) << "\n";
    return 0;
}