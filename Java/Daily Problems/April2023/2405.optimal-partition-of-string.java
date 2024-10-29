package April2023;

import java.util.*;
/*
 * @lc app=leetcode id=2405 lang=java
 *
 * [2405] Optimal Partition of String
 */

// @lc code=start
class Solution {
    public int partitionString(String s) {
        int ans = 0;
        Set<Character> st = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!st.contains(s.charAt(i))) {
                st.add(s.charAt(i));
            } else {
                ans++;
                st.clear();
                st.add(s.charAt(i));
            }
        }
        return ++ans;
    }
}
// @lc code=end