package Grind75.Week1;

import java.util.HashMap;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray())
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);
            if (mp.get(ch) == -1)
                return false;
        }
        return true;
    }
}

// @lc code=end