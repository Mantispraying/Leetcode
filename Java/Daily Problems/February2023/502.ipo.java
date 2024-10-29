package February2023;

import java.util.*;
/*
 * @lc app=leetcode id=502 lang=java
 *
 * [502] IPO
 */

// @lc code=start
class Solution {
    class Project implements Comparable<Project> {
        int capital, profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project project) {
            return capital - project.capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Project[] projects = new Project[profits.length];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        int curr = 0;
        for (int i = 0; i < k; i++) {
            while (curr < projects.length && projects[curr].capital <= w) {
                pq.add(projects[curr++].profit);
            }
            if (pq.isEmpty()) {
                break;
            }
            w += pq.poll();
        }
        return w;
    }
}
// @lc code=end