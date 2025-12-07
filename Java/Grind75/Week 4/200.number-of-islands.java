import java.util.*;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    count++;
                    visitIsland(vis, grid, i, j);
                }
            }
        }
        return count;
    }

    private void visitIsland(boolean[][] vis, char[][] grid, int row, int col) {
        vis[row][col] = true;
        if ((row + 1) < grid.length && grid[row + 1][col] == '1' && vis[row + 1][col] == false) {
            visitIsland(vis, grid, row + 1, col);
        }
        if ((col + 1) < grid[0].length && grid[row][col + 1] == '1' && vis[row][col + 1] == false) {
            visitIsland(vis, grid, row, col + 1);
        }
        if ((row - 1) >= 0 && grid[row - 1][col] == '1' && vis[row - 1][col] == false) {
            visitIsland(vis, grid, row - 1, col);
        }
        if ((col - 1) >= 0 && grid[row][col - 1] == '1' && vis[row][col - 1] == false) {
            visitIsland(vis, grid, row, col - 1);
        }
    }
}
// @lc code=end
