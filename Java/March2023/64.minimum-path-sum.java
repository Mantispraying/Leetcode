package March2023;

import java.util.Arrays;

/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    private int traverse(int[][] grid, int x, int y, int[][] dp) {
        if (x == grid.length || y == grid[0].length)
            return (int) 1e9;
        if (dp[x][y] != -1)
            return dp[x][y];
        if (x == grid.length - 1 && y == grid[0].length - 1)
            return grid[x][y];
        return dp[x][y] = Math.min(traverse(grid, x + 1, y, dp) + grid[x][y],
                traverse(grid, x, y + 1, dp) + grid[x][y]);
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return traverse(grid, 0, 0, dp);
    }
}
// @lc code=end