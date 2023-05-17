package May2023;

import java.util.*;

/*
 * @lc app=leetcode id=1456 lang=java
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
        }
        int answer = count;
        for (int i = k; i < s.length(); i++) {
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
            count -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
// @lc code=end