package April2023;
/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target)
                l = m + 1;
            else if (nums[m] > target)
                r = m - 1;
            else
                return m;
        }
        return -1;
    }
}
// @lc code=end