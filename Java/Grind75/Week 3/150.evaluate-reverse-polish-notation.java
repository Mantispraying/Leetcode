import java.util.*;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int a = 0, b = 0;
        for (String str : tokens) {
            switch (str) {
                case "+":
                    a = stk.pop();
                    b = stk.pop();
                    stk.push(b
                            + a);
                    break;
                case "-":
                    a = stk.pop();
                    b = stk.pop();
                    stk.push(b
                            - a);
                    break;
                case "*":
                    a = stk.pop();
                    b = stk.pop();
                    stk.push(b
                            * a);
                    break;
                case "/":
                    a = stk.pop();
                    b = stk.pop();
                    stk.push(b
                            / a);
                    break;
                default:
                    stk.push(Integer.parseInt(str));
                    break;
            }
        }
        return (stk.peek());
    }
}
// @lc code=end
