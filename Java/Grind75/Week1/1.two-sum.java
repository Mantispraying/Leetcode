import java.util.*;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(target - nums[i])) {
                int ans[] = { mp.get(target - nums[i]), i };
                return ans;
            }
            mp.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end
