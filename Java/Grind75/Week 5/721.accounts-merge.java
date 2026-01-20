import java.util.*;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int n) {
        this.size = new ArrayList<>(Collections.nCopies(n, 1));
        this.parent = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            parent.add(i);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_v = findUParent(v);
        int ulp_u = findUParent(u);
        if (ulp_u == ulp_v) {
            return;
        }
        if (size.get(ulp_u) > size.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public int findUParent(int s) {
        if (parent.get(s) == s) {
            return s;
        }
        int ulp = findUParent(parent.get(s));
        parent.set(s, ulp);
        return ulp;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds = new DisjointSet(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    ds.unionBySize(i, map.get(email));
                }
            }
        }
        List<List<String>> merged = new ArrayList<>(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            merged.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            merged.get(ds.findUParent(entry.getValue())).add(entry.getKey());
        }
        for (int i = 0; i < merged.size(); i++) {
            if (merged.get(i).size() == 0) {
                continue;
            }
            Collections.sort(merged.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String email : merged.get(i)) {
                temp.add(email);
            }
            ans.add(temp);
        }
        return ans;
    }
}
// @lc code=end
