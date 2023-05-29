package May2023;

/*
 * @lc app=leetcode id=837 lang=java
 *
 * [837] New 21 Game
 */

// @lc code=start
class Solution {
    public double new21Game(int N, int K, int W) {
        if (N >= K + W - 1)
            return 1.0;

        double[] p = new double[N + 1];
        p[0] = 1.0;

        double prev = 0.0;
        for (int i = 1; i <= K; i++) {
            prev += p[i - 1] - ((i - W - 1) >= 0 ? p[i - 1 - W] : 0);
            p[i] = prev * 1 / (W * 1.0);
        }

        double res = p[K];
        for (int i = K + 1; i < N + 1; i++) {
            prev -= (i - 1 - W >= 0 ? p[i - 1 - W] : 0);
            p[i] = prev * 1 / (W * 1.0);
            res += p[i];
        }

        return res;
    }

}
// @lc code=end