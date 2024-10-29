package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=1626 lang=java
 *
 * [1626] Best Team With No Conflicts
 */

// @lc code=start
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] pairs = new int[scores.length][2];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i][0] = scores[i];
            pairs[i][1] = ages[i];
        }
        Arrays.sort(pairs, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int[] dp = new int[pairs.length];
        dp[0] = pairs[0][0];
        int max = dp[0];
        for (int i = 1; i < pairs.length; i++) {
            dp[i] = pairs[i][0];
            for (int j = 0; j < i; j++) {
                if (pairs[j][0] <= pairs[i][0]) {
                    dp[i] = Math.max(dp[i], pairs[i][0] + dp[j]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

// @lc code=end