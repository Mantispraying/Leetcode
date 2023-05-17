package March2023;

/*
 * @lc app=leetcode id=2444 lang=java
 *
 * [2444] Count Subarrays With Fixed Bounds
 */

// @lc code=start
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long minPos = -1, maxPos = -1, leftBound = -1, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK)
                leftBound = i;
            if (nums[i] == minK)
                minPos = i;
            if (nums[i] == maxK)
                maxPos = i;
            ans += Math.max(0, Math.min(minPos, maxPos) - leftBound);
        }
        return ans;
    }
}
// @lc code=end