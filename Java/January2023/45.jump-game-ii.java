package January2023;

/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curReach = Math.max(curReach, nums[i] + i);
            if (i == curEnd) {
                curEnd = curReach;
                jumps++;
            }
        }
        return jumps;
    }
}
// @lc code=end