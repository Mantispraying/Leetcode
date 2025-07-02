import java.util.*;

/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int i : prices) {
            if (i < min) {
                min = i;
            }
            if (i - min > profit) {
                profit = i - min;
            }
        }
        return profit;
    }
}
// @lc code=end
