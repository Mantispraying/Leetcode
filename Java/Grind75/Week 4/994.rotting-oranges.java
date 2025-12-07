import java.util.*;

/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new ArrayDeque<>();
        boolean[][] rot = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[] { i, j });
                    rot[i][j] = true;
                }
            }
        }
        while (!rotten.isEmpty()) {
            Queue<int[]> tempQueue = new ArrayDeque<>();
            while (!rotten.isEmpty()) {
                int[] orange = rotten.poll();
                if (orange[0] - 1 >= 0 && grid[orange[0] - 1][orange[1]] == 1 && !rot[orange[0] - 1][orange[1]]) {
                    tempQueue.add(new int[] { orange[0] - 1, orange[1] });
                    rot[orange[0] - 1][orange[1]] = true;
                }
                if (orange[1] - 1 >= 0 && grid[orange[0]][orange[1] - 1] == 1 && !rot[orange[0]][orange[1] - 1]) {
                    tempQueue.add(new int[] { orange[0], orange[1] - 1 });
                    rot[orange[0]][orange[1] - 1] = true;
                }
                if (orange[0] + 1 < grid.length && grid[orange[0] + 1][orange[1]] == 1
                        && !rot[orange[0] + 1][orange[1]]) {
                    tempQueue.add(new int[] { orange[0] + 1, orange[1] });
                    rot[orange[0] + 1][orange[1]] = true;
                }
                if (orange[1] + 1 < grid[0].length && grid[orange[0]][orange[1] + 1] == 1
                        && !rot[orange[0]][orange[1] + 1]) {
                    tempQueue.add(new int[] { orange[0], orange[1] + 1 });
                    rot[orange[0]][orange[1] + 1] = true;
                }
            }
            if (!tempQueue.isEmpty()) {
                rotten.addAll(tempQueue);
                count++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!rot[i][j] && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
// @lc code=end
