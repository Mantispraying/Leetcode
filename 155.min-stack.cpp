#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=155 lang=cpp
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack
{
private:
    long long mini;
    stack<long long> stk;

public:
    MinStack()
    {
        mini = LLONG_MAX;
        while (!stk.empty())
        {
            stk.pop();
        }
    }

    void push(long long val)
    {
        if (stk.empty())
        {
            stk.push(val);
            mini = val;
        }
        else if (val < mini)
        {
            stk.push(2 * val * 1LL - mini);
            mini = val;
        }
        else
        {
            stk.push(val);
        }
    }

    void pop()
    {
        if (stk.empty())
        {
            return;
        }
        long long temp = stk.top();
        stk.pop();
        if (temp < mini)
        {
            mini = 2 * mini - temp;
        }
    }

    int top()
    {
        if (stk.empty())
        {
            return NULL;
        }
        long long temp = stk.top();
        if (temp < mini)
        {
            return mini;
        }
        return temp;
    }

    int getMin()
    {
        if (stk.empty())
        {
            return NULL;
        }
        return mini;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
// @lc code=end
