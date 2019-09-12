import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/9/12
 */
public class LRUCache {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache.
     * It should support the following operations: get and put.
     * <p>
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present.
     * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     * <p>
     * The cache is initialized with a positive capacity.
     * <p>
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * @param capacity
     */

    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
