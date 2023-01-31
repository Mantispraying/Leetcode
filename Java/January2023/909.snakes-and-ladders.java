package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=909 lang=java
 *
 * [909] Snakes and Ladders
 */

// @lc code=start
class Solution {
    private int[] findCoordinate(int currVal, int n) {
        int r = n - (currVal - 1) / n - 1;
        int c = (currVal - 1) % n;
        if (r % 2 == n % 2)
            return new int[] { r, n - 1 - c };
        else
            return new int[] { r, c };
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length, steps = 0;
        boolean visited[][] = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int currVal = queue.poll();
                if (currVal == n * n)
                    return steps;
                for (int dice = 1; dice <= 6; dice++) {
                    if (dice + currVal > n * n)
                        continue;
                    int[] coordinates = findCoordinate(currVal + dice, n);
                    int r = coordinates[0];
                    int c = coordinates[1];
                    if (visited[r][c])
                        continue;
                    visited[r][c] = true;
                    if (board[r][c] == -1)
                        queue.add(currVal + dice);
                    else
                        queue.add(board[r][c]);
                }
            }
            steps++;
        }
        return -1;
    }
}
// @lc code=end