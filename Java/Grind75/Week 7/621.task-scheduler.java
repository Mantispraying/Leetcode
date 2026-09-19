import java.util.*;

/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> queue = new ArrayDeque<>();
        int t = 0;
        int[] frequency = new int[26];
        for (char ch : tasks) {
            frequency[ch - 'A']++;
        }
        for (int i : frequency) {
            if (i > 0) {
                pq.add(i);
            }
        }
        while ((!pq.isEmpty()) || (!queue.isEmpty())) {
            int task = 0;
            if (pq.peek() != null) {
                task = pq.poll();
            }
            t++;
            if (--task > 0) {
                queue.add(new int[] { task, t + n });
            }
            if (queue.peek() != null && queue.peek()[1] == t) {
                pq.add(queue.poll()[0]);
            }
        }
        return t;
    }
}
// @lc code=end
