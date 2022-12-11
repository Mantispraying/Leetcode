package Grind75.Week2;
/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
}
// @lc code=end
