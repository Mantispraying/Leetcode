package Grind75.Week2;

import java.util.*;
/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            if ((freq.getOrDefault(ch, 0) - 1) < 0)
                return false;
            freq.put(ch, freq.get(ch) - 1);
        }
        return true;
    }
}
// @lc code=end