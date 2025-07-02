import java.util.*;

/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length, m;
        while (l < r) {
            m = ((r - l) / 2) + l;
            if (nums[m] == target) {
                return m;
            }
            if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return -1;
    }
}
// @lc code=end
