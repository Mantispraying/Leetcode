package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=1443 lang=java
 *
 * [1443] Minimum Time to Collect All Apples in a Tree
 */

// @lc code=start
class Solution {
    private int checkTime(HashMap<Integer, List<Integer>> branches, List<Boolean> hasApple, int[] visited,
            int currBranch) {
        visited[currBranch] = 1;
        int time = 0;
        for (int nextBranch : branches.get(currBranch)) {
            if (visited[nextBranch] == 1)
                continue;
            time += checkTime(branches, hasApple, visited, nextBranch);
        }
        if ((time == 0 && hasApple.get(currBranch)) || time != 0)
            time += 2;
        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> branches = new HashMap<>();
        for (int[] edge : edges) {
            branches.computeIfAbsent(edge[0], value -> new ArrayList<>()).add(edge[1]);
            branches.computeIfAbsent(edge[1], value -> new ArrayList<>()).add(edge[0]);
        }
        int[] visited = new int[n];
        visited[0] = 1;
        int time = checkTime(branches, hasApple, visited, 0);
        return time == 0 ? 0 : time - 2;
    }
}

// @lc code=end
class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        System.out.println(sol.minTime(7, edges, hasApple));
    }
}