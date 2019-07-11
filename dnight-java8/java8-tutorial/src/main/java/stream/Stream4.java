package stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Stream4 {

    /**
     * 需要注意的是，对于基本数值型，目前有三种对应的包装类型 Stream：
     * <p>
     * IntStream、LongStream、DoubleStream。
     * 当然我们也可以用 Stream<Integer>、Stream<Long> >、Stream<Double>，
     * 但是 boxing 和 unboxing 会很耗时，所以特别为这三种基本数值型提供了对应的 Stream。
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
        IntStream.range(0, 10)
                .forEach(i -> {
                    if (i % 2 == 1) {
                        System.out.print(i + ", ");
                    }
                });

        IntStream.range(0, 10)
                .filter(i -> i % 2 == 1)
                .forEach(System.out::print);

        OptionalInt reduced1 = IntStream.range(0, 10)
                .reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());

        int reduce2 = IntStream.range(0, 10)
                .reduce(7, (a, b) -> a + b);
        System.out.println(reduce2);

        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }
}
