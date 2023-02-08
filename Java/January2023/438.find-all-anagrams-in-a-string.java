package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (sMap[i] == pMap[i]) {
                count++;
            }
        }
        if (count == 26) {
            ans.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            int l = s.charAt(i - p.length()) - 'a', r = s.charAt(i) - 'a';
            sMap[l]--;
            if (sMap[l] == pMap[l]) {
                count++;
            } else if (sMap[l] == pMap[l] - 1) {
                count--;
            }
            sMap[r]++;
            if (sMap[r] == pMap[r]) {
                count++;
            } else if (sMap[r] == pMap[r] + 1) {
                count--;
            }
            if (count == 26) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}
// @lc code=end