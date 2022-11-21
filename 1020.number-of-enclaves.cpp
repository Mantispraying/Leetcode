#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1020 lang=cpp
 *
 * [1020] Number of Enclaves
 */

// @lc code=start
class Solution
{
public:
    int numEnclaves(vector<vector<int>> &grid)
    {
        vector<int> dir = {-1, 0, 1, 0, -1};
        queue<pair<int, int>> q;
        int m = grid.size(), n = grid[0].size(), ans = 0;
        for (int i = 0; i < n; i++)
        {
            if (grid[0][i] == 1)
            {
                grid[0][i] = 2;
                q.push({0, i});
            }
            if (grid[m - 1][i] == 1)
            {
                grid[m - 1][i] = 2;
                q.push({m - 1, i});
            }
        }
        for (int i = 0; i < m; i++)
        {
            if (grid[i][0] == 1)
            {
                grid[i][0] = 2;
                q.push({i, 0});
            }
            if (grid[i][n - 1] == 1)
            {
                grid[i][n - 1] = 2;
                q.push({i, n - 1});
            }
        }
        while (!q.empty())
        {
            pair<int, int> pr = q.front();
            q.pop();
            for (int i = 0; i < 4; i++)
            {
                int ncol = pr.first + dir[i];
                int nrow = pr.second + dir[i + 1];
                if (ncol >= 0 && nrow >= 0 && ncol != m && nrow != n && grid[ncol][nrow] == 1)
                {
                    grid[ncol][nrow] = 2;
                    q.push({ncol, nrow});
                }
            }
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                    ans++;
            }
        }
        return ans;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    vector<vector<int>> grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
    sol.numEnclaves(grid);
    return 0;
}