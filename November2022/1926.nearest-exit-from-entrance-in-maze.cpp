#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=1926 lang=cpp
 *
 * [1926] Nearest Exit from Entrance in Maze
 */

// @lc code=start
class Solution
{
public:
    int nearestExit(vector<vector<char>> &maze, vector<int> &entrance)
    {
        queue<vector<int>> q;
        vector<int> dir = {-1, 0, 1, 0, -1}, curr;
        q.push(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int moves = 1, rows = maze.size(), cols = maze[0].size();

        while (!q.empty())
        {
            int sz = q.size();
            while (sz--)
            {
                curr = q.front();
                q.pop();
                for (int i = 0; i < 4; i++)
                {
                    int nrow = curr[0] + dir[i], ncol = curr[1] + dir[i + 1];
                    if (nrow >= 0 && ncol >= 0 && nrow != rows && ncol != cols && maze[nrow][ncol] == '.')
                    {
                        if ((ncol * nrow == 0 || nrow == rows - 1 || ncol == cols - 1) && maze[nrow][ncol] == '.')
                        {
                            return moves;
                        }
                        maze[nrow][ncol] = '+';
                        q.push({nrow, ncol});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    vector<vector<char>> maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
    vector<int> entrance = {1, 2};
    sol.nearestExit(maze, entrance);
    return 0;
}