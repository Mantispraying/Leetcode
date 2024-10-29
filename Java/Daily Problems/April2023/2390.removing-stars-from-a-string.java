package April2023;

import java.util.*;
/*
 * @lc app=leetcode id=2390 lang=java
 *
 * [2390] Removing Stars From a String
 */

// @lc code=start
class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            if (ch == '*')
                stk.pop();
            else
                stk.add(ch);
        }
        while (!stk.empty())
            ans.append(stk.pop());
        return ans.reverse().toString();
    }
}
// @lc code=end