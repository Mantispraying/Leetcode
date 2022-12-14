package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] daysToWarm = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stk.empty() && temperatures[i] > temperatures[stk.peek()]) {
                int idx = stk.pop();
                daysToWarm[idx] = i - idx;
            }
            stk.push(i);
        }
        return daysToWarm;
    }
}

// @lc code=end