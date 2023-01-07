package January2023;
/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0, overallSurplus = 0, start = 0;
        for (int i = 0; i < cost.length; i++) {
            overallSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }
        return overallSurplus < 0 ? -1 : start;
    }
}

// @lc code=end
class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] gas = { 3, 4, 5, 1, 2 };
        int[] cost = { 1, 2, 3, 4, 5 };
        System.out.println(sol.canCompleteCircuit(gas, cost));
    }
}