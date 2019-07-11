package misc;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class CheckedFunctions {

    @FunctionalInterface
    public interface CheckedConsumer<T> {
        void accept(T input) throws Exception;
    }

    @FunctionalInterface
    public interface CheckedPredicate<T> {
        boolean test(T input) throws Exception;
    }

    @FunctionalInterface
    public interface CheckedFunction<F, T> {
        T apply(F input) throws Exception;
    }

    public static <F, T> Function<F, T> function(CheckedFunction<F, T> function) {
        return input -> {
            try {
                return function.apply(input);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw (RuntimeException) e;
                }
                throw new RuntimeException(e);
            }
        };
    }

    public static <T> Predicate<T> predicate(CheckedPredicate<T> predicate) {
        return input -> {
            try {
                return predicate.test(input);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw (RuntimeException) e;
                }
                throw new RuntimeException(e);
            }
        };
    }

    public static <T> Consumer<T> consumer(CheckedConsumer<T> consumer) {
        return input -> {
            try {
                consumer.accept(input);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    throw (RuntimeException) e;
                }
                throw new RuntimeException(e);
            }
        };
    }
}
