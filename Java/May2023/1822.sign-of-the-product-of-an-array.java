package May2023;

/*
 * @lc app=leetcode id=1822 lang=java
 *
 * [1822] Sign of the Product of an Array
 */

// @lc code=start
class Solution {
    public int arraySign(int[] nums) {
        boolean sign = true;
        for (int num : nums) {
            if (num == 0)
                return 0;
            if (num < 0)
                sign = !sign;
        }
        return sign ? 1 : -1;
    }
}
// @lc code=end