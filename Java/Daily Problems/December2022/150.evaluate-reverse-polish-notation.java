package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int b = st.pop(), a = st.pop();
                st.push(a + b);
            } else if (str.equals("-")) {
                int b = st.pop(), a = st.pop();
                st.push(a - b);
            } else if (str.equals("*")) {
                int b = st.pop(), a = st.pop();
                st.push(a * b);
            } else if (str.equals("/")) {
                int b = st.pop(), a = st.pop();
                st.push(a / b);
            } else {
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }
}
// @lc code=end
