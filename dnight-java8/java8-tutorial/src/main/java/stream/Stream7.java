package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Stream7 {

    static class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    static class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        test1();

        System.out.println();
        test2();

        //flatMap 把 input Stream 中的层级结构扁平化，
        // 就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
    }

    private static void test2() {
        IntStream.range(1, 4)
                .mapToObj(num -> new Foo("Foo" + num))
                .peek(f -> IntStream.range(2, 5)
                        .mapToObj(num -> new Bar("Bar" + num + "<-" + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }

    private static void test1() {
        List<Foo> foos = new ArrayList<>();
        IntStream.range(1, 4)
                .forEach(num -> foos.add(new Foo("Foo" + num)));

        foos.forEach(f -> IntStream.range(1, 4).forEach(num -> f.bars.add(
                new Bar("Bar" + num + "<-" + f.name)
        )));

        foos.stream().flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }
}
