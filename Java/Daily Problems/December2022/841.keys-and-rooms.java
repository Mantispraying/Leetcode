package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];
        stack.push(0);
        while (!stack.empty()) {
            int room = stack.pop();
            visited[room] = true;
            for (int key : rooms.get(room)) {
                if (!visited[key])
                    stack.push(key);
            }
        }
        for (boolean room : visited) {
            if (!room)
                return false;
        }
        return true;
    }
}
// @lc code=end
