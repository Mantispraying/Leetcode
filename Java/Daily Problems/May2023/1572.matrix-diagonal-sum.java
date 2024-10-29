package May2023;

/*
 * @lc app=leetcode id=1572 lang=java
 *
 * [1572] Matrix Diagonal Sum
 */

// @lc code=start
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += mat[i][i];
            ans += mat[n - 1 - i][i];
        }
        if (n % 2 != 0) {
            ans -= mat[n / 2][n / 2];
        }

        return ans;
    }
}
// @lc code=end