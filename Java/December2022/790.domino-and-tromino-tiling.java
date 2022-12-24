package December2022;

import java.util.Arrays;

/*
 * @lc app=leetcode id=790 lang=java
 *
 * [790] Domino and Tromino Tiling
 */

// @lc code=start
class Solution {
    private int calculateTile(int n, int state, int[][] dp) {
        if (n == 0) {
            if (state == 1 || state == 2)
                return 0;
            return 1;
        }
        if (n < 0)
            return 0;
        if (dp[n][state] != -1)
            return dp[n][state];
        int ans = 0;
        if (state == 0) {
            ans += calculateTile(n - 1, 0, dp);
            ans %= 1000000007;
            ans += calculateTile(n - 2, 0, dp);
            ans %= 1000000007;
            ans += calculateTile(n - 1, 2, dp);
            ans %= 1000000007;
            ans += calculateTile(n - 1, 1, dp);
            ans %= 1000000007;
        } else if (state == 1) {
            ans += calculateTile(n - 1, 2, dp);
            ans %= 1000000007;
            ans += calculateTile(n - 2, 0, dp);
            ans %= 1000000007;
        } else {
            ans += calculateTile(n - 1, 1, dp);
            ans %= 1000000007;
            ans += calculateTile(n - 2, 0, dp);
            ans %= 1000000007;
        }
        return dp[n][state] = ans;
    }

    public int numTilings(int n) {
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = (calculateTile(n, 0, dp));
        return ans % 1000000007;
    }
}

// @lc code=end
class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numTilings(10));
    }
}