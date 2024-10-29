package April2023;

import java.util.*;
/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(')
                stk.push(ch);
            else if (stk.empty())
                return false;
            else if (ch == '}' && stk.peek() == '{')
                stk.pop();
            else if (ch == ']' && stk.peek() == '[')
                stk.pop();
            else if (ch == ')' && stk.peek() == '(')
                stk.pop();
            else
                return false;
        }
        return stk.empty();
    }
}
// @lc code=end