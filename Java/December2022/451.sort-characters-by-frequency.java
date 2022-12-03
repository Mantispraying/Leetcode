package December2022;

import java.util.*;
/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.frequencySort("tree");
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] bucket = new List[s.length() + 1];
        for (char ch : map.keySet()) {
            int frequeny = map.get(ch);
            if (bucket[frequeny] == null)
                bucket[frequeny] = new ArrayList<>();
            bucket[frequeny].add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null)
                for (char ch : bucket[i])
                    for (int j = 0; j < i; j++)
                        sb.append(ch);
        }
        return sb.toString();
    }
}
// @lc code=end
