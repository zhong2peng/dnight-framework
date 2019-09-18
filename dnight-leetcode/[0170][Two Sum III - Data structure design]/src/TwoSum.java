import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class TwoSum {

    /**
     * Design and implement a TwoSum class.
     * It should support the following operations:add and find.
     * <p>
     * add - Add the number to an internal data structure.
     * find - Find if there exists any pair of numbers which sum is equal to the value.
     * <p>
     * For example,
     * <p>
     * add(1); add(3); add(5);
     * find(4) -> true
     * find(7) -> false
     * <p>
     * [分析]
     * HASH table O(N)存, O(1) 取
     */

    Map<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (int key : map.keySet()) {
            int another = value - key;
            if (another == key && map.get(key) > 1) {
                return true;
            } else if (another != key && map.containsKey(another)) {
                return true;
            }
        }
        return false;
    }
}
