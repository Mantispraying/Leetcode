package January2023;

/*
 * @lc app=leetcode id=1071 lang=java
 *
 * [1071] Greatest Common Divisor of Strings
 */

// @lc code=start
class Solution {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length(), gcd = gcd(len1, len2);
        String subStr = str1.substring(0, gcd);
        for (int i = 0; i < len1; i += gcd) {
            if (!str1.substring(i, i + gcd).equals(subStr))
                return "";
        }
        for (int i = 0; i < len2; i += gcd) {
            if (!str2.substring(i, i + gcd).equals(subStr))
                return "";
        }
        return subStr;
    }
}
// @lc code=end