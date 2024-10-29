package March2023;
/*
 * @lc app=leetcode id=2187 lang=java
 *
 * [2187] Minimum Time to Complete Trips
 */

// @lc code=start
class Solution {
    private boolean tripsPossible(int[] times, long passedTime, int trips) {
        long possibleTrips = 0;
        for (int time : times) {
            possibleTrips += passedTime / time;
        }
        return possibleTrips >= trips;
    }

    public long minimumTime(int[] times, int totalTrips) {
        int maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(time, maxTime);
        }
        long l = 1, r = (long) maxTime * totalTrips;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (tripsPossible(times, m, totalTrips)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
// @lc code=end