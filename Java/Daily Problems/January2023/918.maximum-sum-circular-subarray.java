package January2023;

/*
 * @lc app=leetcode id=918 lang=java
 *
 * [918] Maximum Sum Circular Subarray
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE, curMaxSum = 0, curMinSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            curMaxSum += nums[i];
            curMinSum += nums[i];
            maxSum = Math.max(maxSum, curMaxSum);
            minSum = Math.min(minSum, curMinSum);
            if (curMaxSum < 0)
                curMaxSum = 0;
            if (curMinSum > 0)
                curMinSum = 0;
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
// @lc code=end