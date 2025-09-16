import java.util.*;

/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    int helper(int n, int[] dp) {
        if (n <= 3) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = helper(n - 2, dp) + helper(n - 1, dp);
    }
}
// @lc code=end
