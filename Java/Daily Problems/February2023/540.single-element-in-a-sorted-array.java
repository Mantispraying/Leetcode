package February2023;

/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m % 2 == 1)
                m--;
            if (nums[m] != nums[m + 1])
                r = m - 1;
            else
                l = m + 2;
        }
        return nums[l];
    }
}
// @lc code=end