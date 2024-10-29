package April2023;

/*
 * @lc app=leetcode id=2439 lang=java
 *
 * [2439] Minimize Maximum of Array
 */

// @lc code=start
class Solution {
    public int minimizeArrayValue(int[] nums) {
        long ans = 0, prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            ans = Math.max(ans, (prefixSum + i) / (i + 1));
        }
        return (int) (ans);
    }
}
// @lc code=end