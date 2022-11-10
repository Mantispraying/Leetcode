#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=901 lang=cpp
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner
{
private:
    stack<pair<int, int>> stk;

public:
    StockSpanner()
    {
    }

    int next(int price)
    {
        int ans = 1;
        while (!stk.empty() && stk.top().first <= price)
        {
            ans += stk.top().second;
            stk.pop();
        }
        stk.push({price, ans});
        return ans;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */
// @lc code=end
