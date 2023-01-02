package January2023;

/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i)))
                    return false;
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i)))
                    return false;
            }
        }
        return true;
    }
}

// @lc code=end