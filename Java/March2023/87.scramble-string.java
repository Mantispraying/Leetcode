package March2023;
/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        Boolean[][][] dp = new Boolean[s1.length() + 1][s1.length()][s1.length()];
        return isScramble(s1, s2, dp, 0, 0, s1.length());
    }

    private boolean isScramble(String s1, String s2, Boolean[][][] dp, int a, int b, int length) {
        if (dp[length][a][b] != null)
            return dp[length][a][b];
        if (s1.substring(a, a + length).equals(s2.substring(b, b + length)))
            return dp[length][a][b] = true;

        for (int i = 1; i < length; i++) {
            if (isScramble(s1, s2, dp, a, b, i) && isScramble(s1, s2, dp, a + i, b + i, length - i)
                    || isScramble(s1, s2, dp, a, b + length - i, i) && isScramble(s1, s2, dp, a + i, b, length - i))
                return dp[length][a][b] = true;
        }
        return dp[length][a][b] = false;
    }
}
// @lc code=end