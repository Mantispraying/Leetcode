import java.util.*;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int height = mat.length, width = mat[0].length;
        int[][] dist = new int[height][width], vis = new int[height][width];
        Queue<int[]> queue = new ArrayDeque<>();
        // Scanning for 0s
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = 1;
                    dist[i][j] = 0;
                    queue.offer(new int[] { i, j, 0 });
                }
            }
        }
        // bfs
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int[] dirs = { 1, 0, -1, 0, 1 };
            for (int i = 0; i < dirs.length - 1; i++) {
                int row = node[0] + dirs[i];
                int col = node[1] + dirs[i + 1];
                if (row >= 0 && row < height && col >= 0 && col < width && vis[row][col] != 1) {
                    vis[row][col] = 1;
                    dist[row][col] = node[2] + 1;
                    queue.offer(new int[] { row, col, node[2] + 1 });
                }
            }
        }
        return dist;
    }
}
// @lc code=end
