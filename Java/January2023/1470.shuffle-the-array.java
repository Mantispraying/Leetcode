package January2023;
/*
 * @lc app=leetcode id=1470 lang=java
 *
 * [1470] Shuffle the Array
 */

// @lc code=start
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < 2 * n; i += 2) {
            ans[i] = nums[i / 2];
            ans[i + 1] = nums[i / 2 + n];
        }
        return ans;
    }
}
// @lc code=end