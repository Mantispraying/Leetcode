#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=733 lang=cpp
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution
{
public:
    vector<vector<int>> floodFill(vector<vector<int>> &image, int sr, int sc, int color)
    {
        int ocolor = image[sr][sc];

        if (ocolor == color)
        {
            return image;
        }

        image[sr][sc] = color;

        if (!(sr + 1 >= image.size()) && image[sr + 1][sc] == ocolor)
        {
            image = floodFill(image, sr + 1, sc, color);
        }
        if (!(sc + 1 >= image[0].size()) && image[sr][sc + 1] == ocolor)
        {
            image = floodFill(image, sr, sc + 1, color);
        }
        if (sr - 1 >= 0 && image[sr - 1][sc] == ocolor)
        {
            image = floodFill(image, sr - 1, sc, color);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == ocolor)
        {
            image = floodFill(image, sr, sc - 1, color);
        }
        return image;
    }
};
// @lc code=end
