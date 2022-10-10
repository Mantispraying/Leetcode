#include <bits/stdc++.h>
using namespace std;
/*
 * @lc app=leetcode id=207 lang=cpp
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution
{
private:
    bool dfsCheck(int node, vector<int> adj[], vector<int> &visited, vector<int> &pathvisited)
    {
        visited[node] = 1;
        pathvisited[node] = 1;

        for (int it : adj[node])
        {
            if (!visited[it])
            {
                if (!dfsCheck(it, adj, visited, pathvisited))
                {
                    return false;
                }
            }
            else if (pathvisited[it])
            {
                return false;
            }
        }
        pathvisited[node] = 0;
        return true;
    }

public:
    bool canFinish(int numCourses, vector<vector<int>> &prerequisites)
    {
        vector<int> adj[numCourses];

        for (auto &it : prerequisites)
        {
            adj[it[0]].push_back(it[1]);
        }

        vector<int> visited(numCourses, 0);
        vector<int> pathvisited(numCourses, 0);

        for (int i = 0; i < numCourses; i++)
        {
            if (!visited[i])
            {
                if (!dfsCheck(i, adj, visited, pathvisited))
                {
                    return false;
                }
            }
        }
        return true;
    }
};
// @lc code=end