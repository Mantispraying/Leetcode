import java.util.*;

/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        int index = 0;
        boolean negative = false;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index < s.length() && s.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            index++;
        }
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (res > (Integer.MAX_VALUE / 10) || (res == (Integer.MAX_VALUE / 10) && digit > 7)) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
        return negative ? -res : res;
    }
}
// @lc code=end
