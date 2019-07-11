package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Stream1 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
        stringList.add("vvvv");

        stringList.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        stringList.stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        stringList.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        boolean anyStartsWithA = stringList.stream()
                .anyMatch(s -> s.startsWith("a"));

        System.out.println(anyStartsWithA);

        boolean allStartsWithA = stringList.stream()
                .allMatch(s -> s.startsWith("a"));

        System.out.println(allStartsWithA);

        boolean noneStartsWithZ = stringList.stream()
                .noneMatch(s -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);

        long startsWithB = stringList.stream()
                .filter(s -> s.startsWith("b"))
                .count();
        System.out.println(startsWithB);

        Optional<String> reduced = stringList.stream()
                .sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }
}
