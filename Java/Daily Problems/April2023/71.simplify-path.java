package April2023;

import java.util.*;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (String dir : dirs) {
            if (dir.equals("") || dir.equals("."))
                continue;
            if (dir.equals("..")) {
                if (!q.isEmpty()) {
                    q.removeLast();
                }
            } else {
                q.add(dir);
            }
        }
        for (String dir : q) {
            ans.append("/" + dir);
        }
        if (ans.toString().equals(""))
            ans.append("/");
        return ans.toString();
    }
}
// @lc code=end