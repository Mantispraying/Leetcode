package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=1962 lang=java
 *
 * [1962] Remove Stones to Minimize the Total
 */

// @lc code=start
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            heap.add(pile);
        }
        for (int i = 0; i < k; i++) {
            int topPile = heap.remove();
            topPile = (topPile + 1) / 2;
            heap.add(topPile);
        }
        int remainingStones = 0;
        while (!heap.isEmpty()) {
            remainingStones += heap.remove();
        }
        return remainingStones;
    }
}
// @lc code=end
