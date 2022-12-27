import java.util.*;
/*
 * @lc app=leetcode id=2279 lang=java
 *
 * [2279] Maximum Bags With Full Capacity of Rocks
 */

// @lc code=start
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diff = new int[rocks.length];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int ans = 0;
        for (int i : diff) {
            if (additionalRocks >= i) {
                additionalRocks -= i;
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}

// @lc code=end