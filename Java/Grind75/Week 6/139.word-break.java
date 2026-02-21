import java.util.*;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (word.length() + i <= s.length() && word.equalsIgnoreCase(s.substring(i, i + word.length()))) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = dp[i - word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end
