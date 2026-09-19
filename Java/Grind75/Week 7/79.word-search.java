import java.util.*;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        boolean ans = false;
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (dfs(i, j, board, word, 0, vis)) {
                    return true;
                }
            }
        }
        return ans;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int idx, boolean[][] vis) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }
        if (vis[i][j]) {
            return false;
        }
        boolean ans = false;
        if (board[i][j] == word.charAt(idx)) {
            if (idx == word.length() - 1) {
                return true;
            }
            vis[i][j] = true;
            ans = dfs(i + 1, j, board, word, idx + 1, vis) ||
                    dfs(i - 1, j, board, word, idx + 1, vis) ||
                    dfs(i, j + 1, board, word, idx + 1, vis) ||
                    dfs(i, j - 1, board, word, idx + 1, vis);
            vis[i][j] = false;
        }
        return ans;
    }
}
// @lc code=end
