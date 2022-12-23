package Misc;

import java.util.*;
/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner {
    private Stack<int[]> stk;

    public StockSpanner() {
        stk = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while (!stk.empty() && stk.peek()[1] <= price) {
            ans += stk.pop()[0];
        }
        stk.push(new int[] { ans, price });
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end
