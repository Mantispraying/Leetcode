package May2023;

import java.util.*;
/*
 * @lc app=leetcode id=2140 lang=java
 *
 * [2140] Solving Questions With Brainpower
 */

// @lc code=start
class Solution {
    public long mostPoints(int[][] questions, int idx, long[] dp) {
        if (idx >= questions.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        return dp[idx] = Math.max(mostPoints(questions, idx + 1, dp),
                mostPoints(questions, idx + questions[idx][1] + 1, dp) + questions[idx][0]);
    }

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        Arrays.fill(dp, -1);
        return mostPoints(questions, 0, dp);
    }
}
// @lc code=end