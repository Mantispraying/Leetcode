package April2023;

/*
 * @lc app=leetcode id=1312 lang=java
 *
 * [1312] Minimum Insertion Steps to Make a String Palindrome
 */

// @lc code=start
class Solution {
    private int longestPalindromicSubsequence(String str, int i, int j, Integer[][] dp) {
        if (dp[i][j] != null)
            return dp[i][j];
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (str.charAt(i) == str.charAt(j))
            return dp[i][j] = longestPalindromicSubsequence(str, i + 1, j - 1, dp) + 2;
        return dp[i][j] = Math.max(longestPalindromicSubsequence(str, i + 1, j, dp),
                longestPalindromicSubsequence(str, i, j - 1, dp));
    }

    public int minInsertions(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return s.length() - longestPalindromicSubsequence(s, 0, s.length() - 1, dp);
    }
}
// @lc code=end