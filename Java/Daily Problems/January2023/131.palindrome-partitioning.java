package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private void helper(List<List<String>> ans, List<String> path, String str) {
        if (str == null || str.length() == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(0, i + 1);
            if (!isPalindrome(temp))
                continue;
            path.add(temp);
            helper(ans, path, str.substring(i + 1, str.length()));
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), s);
        return ans;
    }
}
// @lc code=end