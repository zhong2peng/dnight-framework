package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Stream5 {

    public static void main(String[] args) {
        List<String> strings =
                Arrays.asList("d2", "a2", "b1", "b3", "c");

        test6(strings);
    }

    private static void test8(List<String> stringList) {
        Supplier<Stream<String>> streamSupplier = () ->
                stringList.stream()
                        .filter(s -> s.startsWith("a"));
        streamSupplier.get().anyMatch(s -> true);
        streamSupplier.get().noneMatch(s -> true);
    }

    private static void test7(List<String> stringList) {
        Stream<String> stream = stringList.stream()
                .filter(s -> s.startsWith("a"));
        stream.anyMatch(s -> true);
        stream.noneMatch(s -> true);
    }

    private static void test6(List<String> stringList) {
        stringList.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.toLowerCase().startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort:  %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
