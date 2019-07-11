package stream;

import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Stream9 {

    public static void main(String[] args) {
        Arrays.asList("a1", "a2", "a3", "a4", "c2", "c1")
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
