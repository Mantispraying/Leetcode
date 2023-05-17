package March2023;

import java.util.Arrays;

/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    private int calculateCost(int[] days, int[] costs, int currIdx, int[] dp) {
        if (currIdx >= days.length)
            return 0;
        if (dp[currIdx] != -1)
            return dp[currIdx];
        int pass1 = calculateCost(days, costs, currIdx + 1, dp) + costs[0];
        int idx7Days = currIdx;
        while (idx7Days < days.length && days[idx7Days] < days[currIdx] + 7)
            idx7Days++;
        int pass7 = calculateCost(days, costs, idx7Days, dp) + costs[1];
        int idx30Days = currIdx;
        while (idx30Days < days.length && days[idx30Days] < days[currIdx] + 30)
            idx30Days++;
        int pass30 = calculateCost(days, costs, idx30Days, dp) + costs[2];
        return dp[currIdx] = Math.min(pass1, Math.min(pass7, pass30));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return calculateCost(days, costs, 0, dp);
    }
}
// @lc code=end