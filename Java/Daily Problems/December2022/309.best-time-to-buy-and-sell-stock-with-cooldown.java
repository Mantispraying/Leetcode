package December2022;

import java.util.Arrays;

/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    private int calculateProfit(int idx, int[] prices, int state, int[][] dp) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][state] != -1)
            return dp[idx][state];
        int buy = 0, sell = 0, wait = 0;
        if (state < 2) {
            if (state == 0)
                buy = calculateProfit(idx + 1, prices, 2, dp) - prices[idx];
            wait = calculateProfit(idx + 1, prices, 0, dp);
        } else {
            sell = calculateProfit(idx + 1, prices, 1, dp) + prices[idx];
            wait = calculateProfit(idx + 1, prices, 2, dp);
        }
        return dp[idx][state] = Math.max(Math.max(sell, buy), wait);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return calculateProfit(0, prices, 0, dp);
    }
}
// @lc code=end
