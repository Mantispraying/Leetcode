package May2023;
/*
 * @lc app=leetcode id=1491 lang=java
 *
 * [1491] Average Salary Excluding the Minimum and Maximum Salary
 */

// @lc code=start
class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            if (salary[i] > max)
                max = salary[i];
            if (salary[i] < min)
                min = salary[i];
        }
        return (sum - (min + max)) / (double) (salary.length - 2);
    }
}
// @lc code=end