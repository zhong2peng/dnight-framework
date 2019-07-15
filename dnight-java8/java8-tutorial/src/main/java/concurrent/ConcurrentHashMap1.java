package concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class ConcurrentHashMap1 {

    private static void testReduce() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("foo", "bar");
        map.putIfAbsent("han", "solo");
        map.putIfAbsent("r2", "d2");
        map.putIfAbsent("c3", "p0");
        //reduce会通过提供的累计函数，将所有的键和（或）值组合起来。
        String reduced = map.reduce(1, (key, value) -> key + "=" + value,
                (s1, s2) -> s1 + "," + s2);
        System.out.println(reduced);
    }

    public static void testSearch() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("foo", "bar");
        map.putIfAbsent("han", "solo");
        map.putIfAbsent("r2", "d2");
        map.putIfAbsent("c3", "p0");
        System.out.println("\nsearch\n");
        //会对每个键和（或）值应用一个函数，直到该函数返回一个非null的结果，然后search会终止并返回该函数的结果。
        String result1 = map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if (key.equals("foo") && value.equals("bar")) {
                return "foobar";
            }
            return null;
        });
        System.out.println("result1: " + result1);

        String result2 = map.searchValues(1, value -> {
            System.out.println(Thread.currentThread().getName());
            if (value.length() > 3) {
                return value;
            }
            return null;
        });
        System.out.println("result2: " + result2);

    }

    private static void testForEach() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("foo", "bar");
        map.putIfAbsent("han", "solo");
        map.putIfAbsent("r2", "d2");
        map.putIfAbsent("c3", "p0");
        map.forEach(1, (key, value) ->
                System.out.printf("key: %s; value: %s; thread: %s\n", key, value, Thread.currentThread().getName()));
        System.out.println(map.mappingCount());
    }

    public static void main(String[] args) {
        testForEach();
        testReduce();
        testSearch();
    }

}
