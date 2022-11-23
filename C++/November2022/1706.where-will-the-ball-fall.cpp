#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1706 lang=cpp
 *
 * [1706] Where Will the Ball Fall
 */

// @lc code=start
class Solution
{
public:
    vector<int> findBall(vector<vector<int>> &grid)
    {
        int m = grid.size(), n = grid[0].size();

        vector<int> ans;

        for (int i = 0; i < n; i++)
        {
            int i1 = i;

            for (int j = 0; j < m; j++)
            {
                int i2 = i1 + grid[j][i1];

                if (i2 < 0 || i2 >= n || grid[j][i1] != grid[j][i2])
                {
                    i1 = -1;
                    break;
                }
                i1 = i2;
            }
            ans.push_back(i1);
        }
        return ans;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    vector<vector<int>> grid = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
    sol.findBall(grid);
    return 0;
}