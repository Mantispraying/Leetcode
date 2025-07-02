import java.util.*;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for (Character character : s.toCharArray()) {
            sMap.put(character, sMap.getOrDefault(character, 0) + 1);
        }
        for (Character character : t.toCharArray()) {
            sMap.put(character, sMap.getOrDefault(character, 0) - 1);
            if (sMap.get(character).equals(-1)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
