package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=1704 lang=java
 *
 * [1704] Determine if String Halves Are Alike
 */

// @lc code=start
class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> v = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int a = 0, b = 0;
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (v.contains(s.charAt(i)))
                a += 1;
            if (v.contains(s.charAt(j)))
                b += 1;
        }
        return a == b;
    }
}
// @lc code=end
