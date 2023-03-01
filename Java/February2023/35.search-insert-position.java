package February2023;

/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = l + (r - l) / 2;
        while (l <= r) {
            if (target < nums[m])
                r = m - 1;
            else if (target > nums[m])
                l = m + 1;
            else if (target == nums[m])
                return m;
            m = l + (r - l) / 2;
        }
        return m;
    }
}
// @lc code=end