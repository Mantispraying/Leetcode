import java.util.*;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cMap = new HashMap<>();
        int max = 0, l = 0, r = 0, length = s.length();
        while (r < length) {
            while (cMap.containsKey(s.charAt(r))) {
                cMap.remove(s.charAt(l));
                l++;
            }
            cMap.put(s.charAt(r), r);
            r++;
            max = Math.max(max, r - l);
        }
        return max;
    }
}
// @lc code=end
