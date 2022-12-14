package December2022;

import java.util.*;

/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int checkHouse(int[] nums, int[] dp, int pos) {
        if (pos >= nums.length)
            return 0;
        if (dp[pos] != -1)
            return dp[pos];
        return dp[pos] = Math.max(checkHouse(nums, dp, pos + 1), nums[pos] + checkHouse(nums, dp, pos + 2));
    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return checkHouse(nums, dp, 0);
    }
}
// @lc code=end
