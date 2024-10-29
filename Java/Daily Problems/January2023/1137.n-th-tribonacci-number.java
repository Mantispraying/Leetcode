package January2023;

/*
 * @lc app=leetcode id=1137 lang=java
 *
 * [1137] N-th Tribonacci Number
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n < 3)
            return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int temp = c;
            c = a + b + c;
            a = b;
            b = temp;
        }
        return c;
    }
}
// @lc code=end