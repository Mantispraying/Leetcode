#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=150 lang=cpp
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution
{
public:
    int evalRPN(vector<string> &tokens)
    {
        stack<int> stk;
        long a, b;
        for (string &token : tokens)
        {
            if (token == "+")
            {
                a = stk.top();
                stk.pop();
                b = stk.top();
                stk.pop();
                stk.push(b + a);
            }
            else if (token == "-")
            {
                a = stk.top();
                stk.pop();
                b = stk.top();
                stk.pop();
                stk.push(b - a);
            }
            else if (token == "*")
            {
                a = stk.top();
                stk.pop();
                b = stk.top();
                stk.pop();
                stk.push(b * a);
            }
            else if (token == "/")
            {
                a = stk.top();
                stk.pop();
                b = stk.top();
                stk.pop();
                stk.push(b / a);
            }
            else
            {
                stk.push(stoi(token));
            }
        }
        return stk.top();
    }
};
// @lc code=end
// int main()
// {
//     Solution sol;
//     vector<string> tokens = {"4", "13", "5", "/", "+"};
//     cout << sol.evalRPN(tokens);
//     return 0;
// }