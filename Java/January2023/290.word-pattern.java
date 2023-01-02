package January2023;

import java.util.*;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Character, String> idx = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (idx.containsKey(c)) {
                if (!idx.get(c).equals(words[i]))
                    return false;
            } else {
                if (idx.containsValue(words[i]))
                    return false;
                idx.put(c, words[i]);
            }
        }
        return true;
    }
}
// @lc code=end
