package Grind75.Week2;

/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */
class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}
// @lc code=start
/*
 * The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version);
 */

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (isBadVersion(m))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
// @lc code=end
