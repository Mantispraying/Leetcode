package April2023;

import java.util.*;
/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            stk.push(x);
            while (!stk.empty() && stk.peek() == popped[i] && i < popped.length) {
                stk.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
// @lc code=end