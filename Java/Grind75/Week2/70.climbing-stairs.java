package Grind75.Week2;
/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    private int climb(int stair, int[] dp) {
        if (stair == 1 || stair == 0)
            return dp[stair];
        if (dp[stair] != 0)
            return dp[stair];
        return dp[stair] = climb(stair - 1, dp) + climb(stair - 2, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        return climb(n, dp);
    }
}
// @lc code=end