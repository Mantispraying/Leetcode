package Grind75.Week1;

/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, lowestPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestPrice)
                lowestPrice = prices[i];
            else if (prices[i] - lowestPrice > maxProfit)
                maxProfit = prices[i] - lowestPrice;
        }
        return maxProfit;
    }
}
// @lc code=end
