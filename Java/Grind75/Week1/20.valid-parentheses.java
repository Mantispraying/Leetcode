package Grind75.Week1;

import java.util.*;
/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (st.empty())
                    return false;
                if (ch == ')' && st.peek() == '(')
                    st.pop();
                else if (ch == '}' && st.peek() == '{')
                    st.pop();
                else if (ch == ']' && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        }
        return st.empty();
    }
}
// @lc code=end
