package Grind75.Week2;
/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int mostOcc = 0, freq = 0;
        for (int num : nums) {
            if (freq == 0) {
                mostOcc = num;
                freq++;
                continue;
            }
            if (num == mostOcc)
                freq++;
            else
                freq--;
        }
        return mostOcc;
    }
}
// @lc code=end