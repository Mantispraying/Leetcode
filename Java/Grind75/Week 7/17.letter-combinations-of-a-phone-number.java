import java.util.*;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        ans.add("");
        String[][] map = { {}, {}, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
                { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };
        for (int i = 0; i < digits.length(); i++) {
            int num = Integer.parseInt(digits.charAt(i) + "");
            int x = ans.size();
            for (int j = 0; j < x; j++) {
                String temp = ans.poll();
                for (String ch : map[num]) {
                    String res = temp + ch;
                    ans.add(res);
                }
            }
        }
        ans.remove("");
        return ans;
    }
}
// @lc code=end
