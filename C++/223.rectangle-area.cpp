#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=223 lang=cpp
 *
 * [223] Rectangle Area
 */

// @lc code=start
class Solution
{
public:
    int areaCalculate(int x1, int y1, int x2, int y2)
    {
        return abs((x2 - x1) * (y2 - y1));
    }

    int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2)
    {
        int areaA = areaCalculate(ax1, ay1, ax2, ay2);
        int areaB = areaCalculate(bx1, by1, bx2, by2);

        // x overlap
        int left = max(ax1, bx1);
        int right = min(ax2, bx2);
        int xOverlap = right - left;

        // y overlap
        int top = min(ay2, by2);
        int bottom = max(ay1, by1);
        int yOverlap = top - bottom;

        int areaOfOverlap = 0;
        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        if (xOverlap > 0 && yOverlap > 0)
        {
            areaOfOverlap = xOverlap * yOverlap;
        }

        // areaOfOverlap is counted twice when in the summation of
        // areaOfA and areaOfB, so we need to subtract it from the
        // total, to get the toal area covered by both the rectangles
        int totalArea = areaA + areaB - areaOfOverlap;

        return totalArea;
    }
};
// @lc code=end
