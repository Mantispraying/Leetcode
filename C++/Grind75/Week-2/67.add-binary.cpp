#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=67 lang=cpp
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution
{
public:
    string addBinary(string a, string b)
    {
        int i = a.size() - 1, j = b.size() - 1, sum = 0, carry = 0;
        string ans;
        while (i >= 0 || j >= 0)
        {
            sum = carry;

            if (i >= 0)
            {
                sum += a[i--] - '0';
            }
            if (j >= 0)
            {
                sum += b[j--] - '0';
            }

            ans += sum % 2 ? '1' : '0';
            carry = sum > 1 ? 1 : 0;
        }
        if (carry)
            ans += '1';

        reverse(ans.begin(), ans.end());
        return ans;
    }
};
// @lc code=end
