package April2023;

import java.util.*;
/*
 * @lc app=leetcode id=2336 lang=java
 *
 * [2336] Smallest Number in Infinite Set
 */

// @lc code=start
class SmallestInfiniteSet {

    TreeSet<Integer> reAdded;
    int maxRemoved;

    public SmallestInfiniteSet() {
        reAdded = new TreeSet<>();
        maxRemoved = 1;
    }

    public int popSmallest() {
        if (reAdded.isEmpty())
            return maxRemoved++;
        return reAdded.pollFirst();
    }

    public void addBack(int num) {
        if (num < maxRemoved)
            reAdded.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
// @lc code=end