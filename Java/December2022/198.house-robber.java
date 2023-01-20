package December2022;

import java.util.*;

/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    private int checkHouse(int[] nums, int[] dp, int idx) {
        if (idx >= nums.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        return dp[idx] = Math.max(checkHouse(nums, dp, idx + 2) + nums[idx], checkHouse(nums, dp, idx + 1));
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return checkHouse(nums, dp, 0);
    }
}
// @lc code=end
