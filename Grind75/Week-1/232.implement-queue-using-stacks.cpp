#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=232 lang=cpp
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue
{
private:
    stack<int> in;
    stack<int> out;

public:
    MyQueue()
    {
    }

    void push(int x)
    {
        in.push(x);
    }

    int pop()
    {
        if (!out.empty())
        {
            int x = out.top();
            out.pop();
            return x;
        }
        while (!in.empty())
        {
            out.push(in.top());
            in.pop();
        }
        int x = out.top();
        out.pop();
        return x;
    }

    int peek()
    {
        if (!out.empty())
        {
            return out.top();
        }
        while (!in.empty())
        {
            out.push(in.top());
            in.pop();
        }
        return out.top();
    }

    bool empty()
    {
        return in.empty() && out.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
// @lc code=end
