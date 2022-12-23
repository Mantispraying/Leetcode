package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] dp, int[][] matrix, int row, int col) {
        if (col < 0 || col == matrix[0].length)
            return Integer.MAX_VALUE;
        if (row == matrix.length - 1)
            return dp[row][col] = matrix[row][col];
        if (dp[row][col] != -200)
            return dp[row][col];
        return dp[row][col] = matrix[row][col] + Math.min(minPathSum(dp, matrix, row + 1, col),
                Math.min(minPathSum(dp, matrix, row + 1, col - 1), minPathSum(dp, matrix, row + 1, col + 1)));
    }

    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -200);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            ans = Math.min(ans, minPathSum(dp, matrix, 0, i));
        }
        return ans;
    }
}

// @lc code=end