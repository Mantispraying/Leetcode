import java.util.*;

/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        for (int i = 1; i < result.length; i++) {
            temp = temp * nums[i - 1];
            result[i] = temp;
        }
        temp = 1;
        for (int i = result.length - 2; i >= 0; i--) {
            temp = temp * nums[i + 1];
            result[i] = temp * result[i];
        }
        return result;
    }
}
// @lc code=end
