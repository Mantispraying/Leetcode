package January2023;
/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int modGroup[] = new int[k];
        modGroup[0] = 1;
        int prefixMod = 0, ans = 0;
        for (int num : nums) {
            prefixMod = (prefixMod + num % k + k) % k;
            ans += modGroup[prefixMod]++;
        }
        return ans;
    }
}
// @lc code=end