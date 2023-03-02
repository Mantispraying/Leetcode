package March2023;
/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int res = 0, count = 0;
        char curr = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (curr != chars[i]) {
                chars[res++] = curr;
                if (count > 1) {
                    for (char ch : Integer.toString(count).toCharArray()) {
                        chars[res++] = ch;
                    }
                }
                count = 0;
                curr = chars[i];
            }
            count++;
        }
        chars[res++] = curr;
        if (count > 1) {
            for (char ch : Integer.toString(count).toCharArray()) {
                chars[res++] = ch;
            }
        }
        return res;
    }
}