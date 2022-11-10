#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1323 lang=cpp
 *
 * [1323] Maximum 69 Number
 */

// @lc code=start
class Solution
{
public:
    int maximum69Number(int num)
    {
        string str = to_string(num);
        for (int i = 0; i < str.size(); i++)
        {
            if (str[i] == '6')
            {
                str[i] = '9';
                break;
            }
        }
        return stoi(str);
    }
};
// @lc code=end
