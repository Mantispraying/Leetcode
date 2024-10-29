package February2023;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i])
                count++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int lCh = s2.charAt(i) - 'a', rCh = s2.charAt(s1.length() + i) - 'a';
            if (count == 26)
                return true;
            s2Map[rCh]++;
            if (s2Map[rCh] == s1Map[rCh]) {
                count++;
            } else if (s2Map[rCh] == s1Map[rCh] + 1) {
                count--;
            }
            s2Map[lCh]--;
            if (s2Map[lCh] == s1Map[lCh]) {
                count++;
            } else if (s2Map[lCh] == s1Map[lCh] - 1) {
                count--;
            }
        }
        return count == 26;
    }
}
// @lc code=end