package March2023;

/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    private boolean possibleEat(int[] piles, int h, int k) {
        int passedHours = 0;
        for (int pile : piles) {
            passedHours += (int) Math.ceil((pile + 0.0) / k);
        }
        return passedHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;
        for (int pile : piles) {
            maxBananas = Math.max(pile, maxBananas);
        }
        int l = 1, r = maxBananas;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (possibleEat(piles, h, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
// @lc code=end