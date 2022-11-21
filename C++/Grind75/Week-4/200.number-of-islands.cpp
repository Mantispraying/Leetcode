#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=200 lang=cpp
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution
{
public:
    void visit(vector<vector<char>> &grid, int i, int j)
    {
        int n = grid.size(), m = grid[0].size();
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] != '1')
        {
            return;
        }
        grid[i][j] = '2';
        visit(grid, i + 1, j);
        visit(grid, i - 1, j);
        visit(grid, i, j + 1);
        visit(grid, i, j - 1);
    }

    int numIslands(vector<vector<char>> &grid)
    {
        int num = 0;
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[0].size(); j++)
            {
                if (grid[i][j] == '1')
                {
                    num++;
                    visit(grid, i, j);
                }
            }
        }
        return num;
    }
};
// @lc code=end
