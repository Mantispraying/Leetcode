package January2023;
/*
 * @lc app=leetcode id=1833 lang=java
 *
 * [1833] Maximum Ice Cream Bars
 */

// @lc code=start
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int m = 0, iceCreams = 0;
        for (int cost : costs)
            if (cost > m)
                m = cost;
        int[] costFreq = new int[m + 1];
        for (int cost : costs)
            costFreq[cost]++;
        for (int i = 1; i < costFreq.length; i++) {
            if (costFreq[i] == 0)
                continue;
            if (i > coins)
                break;
            int iceCreamsBought = Math.min(costFreq[i], coins / i);
            coins -= iceCreamsBought * i;
            iceCreams += iceCreamsBought;
        }
        return iceCreams;
    }
}
// @lc code=end