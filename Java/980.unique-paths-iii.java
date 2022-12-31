/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 */

// @lc code=start
class Solution {
    private boolean visitedTotally(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    private int uniquePathsIII(int row, int col, int[][] grid) {
        if (grid[row][col] == 2) {
            if (visitedTotally(grid))
                return 1;
            return 0;
        }
        int paths = 0;
        int[] dir = { 1, 0, -1, 0, 1 };
        for (int i = 0; i < dir.length - 1; i++) {
            int nrow = row + dir[i];
            int ncol = col + dir[i + 1];
            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 0) {
                grid[nrow][ncol] = 1;
                paths += uniquePathsIII(nrow, ncol, grid);
                grid[nrow][ncol] = 0;
            } else if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 2) {
                paths += uniquePathsIII(nrow, ncol, grid);
            }
        }
        return paths;
    }

    public int uniquePathsIII(int[][] grid) {
        int paths = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    paths += uniquePathsIII(i, j, grid);
                    break;
                }
            }
        }
        return paths;
    }
}

// @lc code=end
class Test {
    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        Solution sol = new Solution();
        System.out.println(sol.uniquePathsIII(grid));
    }
}