package April2023;
/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 */

// @lc code=start
class Solution {
    private void makeWater(int[][] grid, int x, int y) {
        grid[x][y] = 0;
        int[] dir = { 1, 0, -1, 0, 1 };
        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i];
            int newY = y + dir[i + 1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                makeWater(grid, newX, newY);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1)
                makeWater(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1)
                makeWater(grid, i, grid[0].length - 1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1)
                makeWater(grid, 0, i);
            if (grid[grid.length - 1][i] == 1)
                makeWater(grid, grid.length - 1, i);
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    ans++;
            }
        }
        return ans;
    }
}
// @lc code=end