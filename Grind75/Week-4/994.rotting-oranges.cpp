#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=994 lang=cpp
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution
{
public:
    int orangesRotting(vector<vector<int>> &grid)
    {
        int mins = 0, fresh = 0;
        int rows = grid.size(), cols = grid[0].size();
        int dir[] = {-1, 0, 1, 0, -1};
        queue<pair<int, int>> q;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == 2)
                {
                    q.push({i, j});
                    mins = -1;
                }
                else if (grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }

        while (!q.empty())
        {
            int n = q.size();
            for (int i = 0; i < n; i++)
            {
                pair<int, int> pr = q.front();
                q.pop();
                for (int k = 0; k < 4; k++)
                {
                    int r = pr.first + dir[k];
                    int c = pr.second + dir[k+1] ;
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1)
                    {
                        grid[r][c] = 2;
                        fresh--;
                        q.push({r, c});
                    }
                }
            }
            mins++;
        }

        if (fresh > 0)
        {
            return -1;
        }

        return mins;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    vector<vector<int>> grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    sol.orangesRotting(grid);
    return 0;
}