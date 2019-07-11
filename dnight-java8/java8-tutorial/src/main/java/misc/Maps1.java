package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Maps1 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));

        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3)); // val33

        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9)); // false

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23)); // true

        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3)); // val33

        System.out.println(map.getOrDefault(42, "not found")); // not found

        // 3对应的value等于“val3”，才执行删除动作
        map.remove(3, "val3");
        System.out.println(map.get(3)); // val33

        map.remove(3, "val33");
        System.out.println(map.get(3)); // null


        System.out.println(map.get(9)); // val9
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9)); // val9

        map.merge(9, "concat1", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9)); // val9concat

        map.merge(9, "concat2", String::concat);
        System.out.println(map.get(9)); // val9concat
    }
}
