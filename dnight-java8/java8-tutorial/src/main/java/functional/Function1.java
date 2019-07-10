package functional;

import util.Score;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Function1 {

    public static void main(String[] args) {
        Function<String, String> f1 = s -> {
            String _s = s + " world!";
            System.out.println(_s);
            return _s;
        };

        Function<String, String> f2 = s -> {
            String _temp = s + " andThen logistics!";
            System.out.println(_temp);
            return _temp;
        };

        f1.andThen(f2).apply("hello");

        Supplier<Score> supplier = Score::new;
        System.out.println("创建了新对象（无参数）: " + supplier.get());

        Function<String, Score> function1 = Score::new;
        System.out.println("创建了新对象（一个参数）: " + function1.apply("Tom"));

        BiFunction<String, Long, Score> biFunction1 = Score::new;
        System.out.println("创建了新对象（两个参数）: " + biFunction1.apply("Tom", 98L));

        Function<Integer, Function<Integer, Integer>> function2 = x -> y -> x + y;
        System.out.println("compute result: " + function2.apply(2).apply(3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> function3 = x -> y -> z -> (x + y) * z;
        System.out.println("compute result: " + function3.apply(1).apply(2).apply(3));

    }
}
