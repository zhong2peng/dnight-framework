package misc;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Concurrency1 {

    public static void main(String[] args) {
        ConcurrentMap<Integer, UUID> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            concurrentMap.put(i, UUID.randomUUID());
        }
        int threshold = 1;
        ((ConcurrentHashMap<Integer, UUID>) concurrentMap).forEachValue(threshold, System.out::println);
        concurrentMap.forEach(
                (id, uuid) -> {
                    System.out.printf("%s, %s", id, uuid);
                }
        );

        UUID searchResult = ((ConcurrentHashMap<Integer, UUID>) concurrentMap).search(threshold,
                (id, uuid) -> {
                    if (String.valueOf(uuid).startsWith(String.valueOf(id))) {
                        System.out.println(id + " " + uuid);
                        return uuid;
                    }
                    return null;
                });
        System.out.println(searchResult);
    }
}
