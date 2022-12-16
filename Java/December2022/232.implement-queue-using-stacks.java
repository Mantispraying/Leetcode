package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (st2.empty())
            while (!st1.empty()) {
                st2.push(st1.pop());
            }
        return st2.pop();
    }

    public int peek() {
        if (st2.empty())
            while (!st1.empty()) {
                st2.push(st1.pop());
            }
        return st2.peek();
    }

    public boolean empty() {
        return st1.empty() && st2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
class Test {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}