package February2023;

/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0, maxWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
            maxWeight = Math.max(weight, maxWeight);
        }
        int l = maxWeight, r = totalWeight;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (feasible(weights, days, m))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private boolean feasible(int[] weights, int days, int capacity) {
        int daysNeeded = 1, load = 0;
        for (int i = 0; i < weights.length; i++) {
            load += weights[i];
            if (load > capacity) {
                daysNeeded++;
                load = weights[i];
            }
        }
        return daysNeeded <= days;
    }
}
// @lc code=end
