package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    private int[] dp;

    public int waysToClimb(int n) {
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = waysToClimb(n - 1) + waysToClimb(n - 2);
    }

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return waysToClimb(n);
    }
}
// @lc code=end
