import java.util.*;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    Stack<int[]> stk;
    int min;

    public MinStack() {
        stk = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stk.push(new int[] { val, min });
        if (min > val) {
            min = val;
        }
    }

    public void pop() {
        min = stk.pop()[1];
    }

    public int top() {
        return stk.peek()[0];
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
