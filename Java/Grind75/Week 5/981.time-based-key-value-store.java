import java.util.*;

/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class Data {
    String val;
    int time;

    Data(int time, String val) {
        this.val = val;
        this.time = time;
    }
}

class TimeMap {

    Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x -> new ArrayList<>()).add(new Data(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        return binarySearch(map.get(key), timestamp);

    }

    private String binarySearch(List<Data> list, int timestamp) {
        int l = 0, r = list.size() - 1;
        String res = "";
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (list.get(mid).time == timestamp) {
                return list.get(mid).val;
            }
            if (list.get(mid).time < timestamp) {
                res = list.get(mid).val;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end
