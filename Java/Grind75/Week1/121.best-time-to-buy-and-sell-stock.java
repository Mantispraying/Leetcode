package Grind75.Week1;

/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        // loop through all prices
        for (int i = 0; i < prices.length; i++) {
            // update the minimum price if necessary
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // calculate the potential profit from buying at the minimum price
            // and selling at the current price
            int potentialProfit = prices[i] - minPrice;

            // update the max profit if the potential profit is greater
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
        }

        return maxProfit;
    }
}
// @lc code=end
