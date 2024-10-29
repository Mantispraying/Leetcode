package January2023;
/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        int countOne = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                res = Math.min(countOne, res + 1);
            else
                countOne++;
        }
        return res;
    }
}
// @lc code=end