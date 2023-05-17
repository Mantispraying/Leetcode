package May2023;
/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int cnt = 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i; j++) {
                ans[i][j] = cnt++;
            }
            for (int j = i + 1; j < n - i; j++) {
                ans[j][n - i - 1] = cnt++;
            }
            for (int j = i + 1; j < n - i; j++) {
                ans[n - i - 1][n - j - 1] = cnt++;
            }
            for (int j = i + 1; j < n - i - 1; j++) {
                ans[n - j - 1][i] = cnt++;
            }
        }
        return ans;
    }
}
// @lc code=end