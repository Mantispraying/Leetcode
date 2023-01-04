package Grind75.Week2;
import java.util.*;
/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        int length = 0;
        for (int count : freq.values()) {
            length += (count / 2) * 2;
            if (length % 2 == 0 && count % 2 == 1)
                length++;
        }
        return length;
    }
}
// @lc code=end