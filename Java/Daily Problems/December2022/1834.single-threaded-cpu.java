package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=1834 lang=java
 *
 * [1834] Single-Threaded CPU
 */

// @lc code=start
class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] sortedTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        Arrays.sort(sortedTasks, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> nextTask = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int currTime = 0;
        int taskIndex = 0;
        int ansIndex = 0;
        int[] order = new int[sortedTasks.length];
        while (taskIndex < sortedTasks.length || !nextTask.isEmpty()) {
            if (nextTask.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
                currTime = sortedTasks[taskIndex][0];
            }
            while (taskIndex < sortedTasks.length && sortedTasks[taskIndex][0] <= currTime) {
                nextTask.add(sortedTasks[taskIndex]);
                taskIndex++;
            }
            currTime += nextTask.peek()[1];
            order[ansIndex++] = nextTask.remove()[2];
        }
        return order;
    }
}

// @lc code=end
class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tasks = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 4, 1 } };
        sol.getOrder(tasks);
    }
}