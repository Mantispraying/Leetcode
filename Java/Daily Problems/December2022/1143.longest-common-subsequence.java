package December2022;

/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    private int longestCommonSubsequence(Integer[][] dp, String str1, String str2, int idx1, int idx2) {
        if (idx1 == str1.length() || idx2 == str2.length())
            return 0;
        if (dp[idx1][idx2] != null)
            return dp[idx1][idx2];
        if (str1.charAt(idx1) == str2.charAt(idx2))
            return longestCommonSubsequence(dp, str1, str2, idx1 + 1, idx2 + 1) + 1;
        return dp[idx1][idx2] = Math.max(longestCommonSubsequence(dp, str1, str2, idx1 + 1, idx2),
                longestCommonSubsequence(dp, str1, str2, idx1, idx2 + 1));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return longestCommonSubsequence(dp, text1, text2, 0, 0);
    }
}

// @lc code=end
class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestCommonSubsequence("bbm", "mb"));
    }
}