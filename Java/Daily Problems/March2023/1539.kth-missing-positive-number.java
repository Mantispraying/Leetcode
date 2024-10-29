package March2023;
/*
 * @lc app=leetcode id=1539 lang=java
 *
 * [1539] Kth Missing Positive Number
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            int diff = arr[m] - m - 1;
            if (diff >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l + k;
    }
}
// @lc code=end