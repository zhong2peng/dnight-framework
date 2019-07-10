package lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Lambda3 {

    @FunctionalInterface
    interface Fun {
        void foo();
    }

    static Person getPerson() {
        return new Person("fff", "ggg");
    }

    /**
     * Function,Consumer,Predicate,Supplier这些接口有一个共性,
     * 就是都有一个@FunctionalInterface的注解
     * <p>
     * Function接口相关的接口包括：
     * - BiFunction ：R apply(T t, U u);接受两个参数，返回一个值，代表一个二元函数；
     * - DoubleFunction ：R apply(double value);只处理double类型的一元函数；
     * - IntFunction ：R apply(int value);只处理int参数的一元函数；
     * - LongFunction ：R apply(long value);只处理long参数的一元函数；
     * - ToDoubleFunction：double applyAsDouble(T value);返回double的一元函数；
     * - ToDoubleBiFunction：double applyAsDouble(T t, U u);返回double的二元函数；
     * - ToIntFunction：int applyAsInt(T value);返回int的一元函数；
     * - ToIntBiFunction：int applyAsInt(T t, U u);返回int的二元函数；
     * - ToLongFunction：long applyAsLong(T value);返回long的一元函数；
     * - ToLongBiFunction：long applyAsLong(T t, U u);返回long的二元函数；
     * - DoubleToIntFunction：int applyAsInt(double value);接受double返回int的一元函数；
     * - DoubleToLongFunction：long applyAsLong(double value);接受double返回long的一元函数；
     * - IntToDoubleFunction：double applyAsDouble(int value);接受int返回double的一元函数；
     * - IntToLongFunction：long applyAsLong(int value);接受int返回long的一元函数；
     * - LongToDoubleFunction：double applyAsDouble(long value);接受long返回double的一元函数；
     * - LongToIntFunction：int applyAsInt(long value);接受long返回int的一元函数；
     */
    public static void main(String[] args) {
        //即判断输入的对象是否符合某个条件，断言
        Predicate<String> predicate = (s) -> s.length() > 0;
        predicate.test("foo");
        predicate.negate().test("foo");

        Predicate<String> nonNull = Objects::nonNull;
        System.out.println("Objects::nonNull === " + nonNull.test(null));

        Predicate<Boolean> isNull = Objects::isNull;
        System.out.println("Objects::isNull === " + isNull.test(true));

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println("String::isEmpty === " + isEmpty.test(""));
        Predicate<String> isNotEmpty = isEmpty.negate();

        //
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");

        Function<String, String> f1 = (t) -> t + "is coming";
        Function<String, String> f2 = f1.compose(t -> "Hi, " + t);
        System.out.println("Function test = " + f2.apply("Tom"));

        Supplier<Person> personSupplier = () -> {
            return new Person("Tom", "last");
        };
        System.out.println("Suppliers " + personSupplier.get().firstName);

        Supplier<Person> personSupplier1 = Person::new;
        System.out.println("Suppliers " + personSupplier1.get().firstName);

        Supplier<Person> personSupplier2 = Lambda3::getPerson;
        System.out.println("Suppliers " + personSupplier2.get().firstName);

        //一个接受单个输入参数并且没有返回值的操作。不像其他函数式接口，Consumer接口期望执行带有副作用的操作
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));


        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);

        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();

        Callable<UUID> callable = UUID::randomUUID;
        try {
            callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
