package January2023;

import java.util.*;
/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start
class LFUCache {
    private Map<Integer, Integer> cache, counter, lastUpdated;
    private int capacity = 0, callNumber = 0;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        counter = new HashMap<>();
        lastUpdated = new HashMap<>();

        this.capacity = capacity;
    }

    public int get(int key) {
        callNumber++;
        if (counter.containsKey(key)) {
            counter.put(key, counter.get(key) + 1);
        }
        if (lastUpdated.containsKey(key)) {
            lastUpdated.put(key, callNumber);
        }
        return cache.get(key) == null ? -1 : cache.get(key);
    }

    public void put(int key, int value) {
        callNumber++;
        if (capacity <= 0)
            return;
        if (cache.size() + 1 > capacity) {
            Map.Entry<Integer, Integer> min = Collections.min(counter.entrySet(),
                    (Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) -> {
                        return a.getValue().compareTo(b.getValue()) == 0
                                ? lastUpdated.get(a.getKey()).compareTo(lastUpdated.get(b.getKey()))
                                : a.getValue().compareTo(b.getValue());
                    });
            cache.remove(min.getKey());
            counter.remove(min.getKey());
            lastUpdated.remove(min.getKey());
        }
        cache.put(key, value);
        counter.put(key, counter.getOrDefault(key, 0) + 1);
        lastUpdated.put(key, callNumber);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
class Test {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.get(2);
        lfu.put(2, 6);
        lfu.get(1);
        lfu.put(1, 5);
        lfu.get(1);
        System.out.println(lfu.get(2));
    }
}