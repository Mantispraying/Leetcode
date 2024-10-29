package February2023;

import java.util.*;
/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < order.length(); i++)
            dict.put(order.charAt(i), i);

        for (int i = 1; i < words.length; i++) {
            int c;
            for (c = 0; c < words[i - 1].length() && c < words[i].length(); c++) {
                if (dict.get(words[i - 1].charAt(c)) < dict.get(words[i].charAt(c))) {
                    break;
                } else if (dict.get(words[i - 1].charAt(c)) > dict.get(words[i].charAt(c))) {
                    return false;
                }
            }
            if ((c == words[i - 1].length() || c == words[i].length()) && words[i - 1].length() > words[i].length())
                return false;
        }
        return true;
    }
}
// @lc code=end