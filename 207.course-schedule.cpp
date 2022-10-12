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
        vector<int> indegree(numCourses, 0);

        for (auto &it : prerequisites)
        {
            adj[it[1]].push_back(it[0]);
            indegree[it[0]]++;
        }
        queue<int> q;

        for (int i = 0; i < numCourses; i++)
        {
            if (indegree[i] == 0)
            {
                q.push(i);
            }
        }
        vector<int> topo;

        while (!q.empty())
        {
            int node = q.front();
            q.pop();

            topo.push_back(node);

            for (auto it : adj[node])
            {
                indegree[it]--;
                if (indegree[it] == 0)
                {
                    q.push(it);
                }
            }
        }

        if (topo.size() == numCourses)
        {
            return true;
        }
        return false;

        // vector<int> visited(numCourses, 0);
        // vector<int> pathvisited(numCourses, 0);

        // for (int i = 0; i < numCourses; i++)
        // {
        //     if (!visited[i])
        //     {
        //         if (!dfsCheck(i, adj, visited, pathvisited))
        //         {
        //             return false;
        //         }
        //     }
        // }
        // return true;
    }
};
// @lc code=end
int main()
{
    Solution sol;
    vector<vector<int>> prerequisites = {{1, 0}};
    sol.canFinish(2, prerequisites);
    return 0;
}