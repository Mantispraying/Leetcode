package April2023;
/*
 * @lc app=leetcode id=1416 lang=java
 *
 * [1416] Restore The Array
 */

// @lc code=start
class Solution {
    private int checkPossible(String s, int k, int idx, Integer[] dp) {
        if (idx == s.length())
            return 1;
        if (dp[idx] != null)
            return dp[idx];
        if (s.charAt(idx) == '0')
            return dp[idx] = 0;
        int ans = 0;
        for (int i = idx; i < s.length(); i++) {
            if (Long.parseLong(s.substring(idx, i + 1)) > k)
                break;
            ans = (ans + checkPossible(s, k, i + 1, dp)) % 1_000_000_007;
        }
        return dp[idx] = ans;
    }

    public int numberOfArrays(String s, int k) {
        if (s == null)
            return 0;
        Integer[] dp = new Integer[s.length()];
        return checkPossible(s, k, 0, dp);
    }
}
// @lc code=end