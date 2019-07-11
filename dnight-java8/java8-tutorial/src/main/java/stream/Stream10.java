package stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Stream10 {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * public interface Collector<T, A, R> {
     * Supplier<A> supplier();
     * BiConsumer<A, T> accumulator();
     * BinaryOperator<A> combiner();
     * Function<A, R> finisher();
     * Set<Characteristics> characteristics();
     * }
     * <p>
     * Collector接口包含了一系列方法，为实现具体的归约操作(即收集器)提供了范本。
     * 我们已经看过了Collector接口中实现的许多收集器，例如toList或groupingBy。
     * 这也意味着你可以为Collector接口提供自己的实现，从而自由创建自定义归约操作。
     * <p>
     * T是流中要收集的对象的泛型
     * A是累加器的类型，累加器是在收集过程中用于累积部分结果的对象。
     * R是收集操作得到的对象(通常但不一定是集合)的类型。
     * <p>
     * 建立新的结果容器 supplier方法
     * 累加器执行累加的具体实现 accumulator方法
     * 对结果容器应用最终转换 finisher方法
     */
    public static void main(String[] args) {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));
        test5(persons);
//        test9(persons);
    }

    private static void test1(List<Person> persons) {
        List<Person> filtered = persons
                .stream()
                .filter(p -> p.name.startsWith("P"))
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void test2(List<Person> persons) {
        Map<Integer, List<Person>> personByAge = persons.stream()
                .collect(Collectors.groupingBy(p -> p.age));
        personByAge.forEach((age, p) ->
                System.out.printf("age %s: %s\n", age, p));
    }

    private static void test3(List<Person> persons) {
        Double averageAge = persons.stream()
                .collect(Collectors.averagingInt(p -> p.age));
        System.out.println(averageAge);
    }

    private static void test4(List<Person> persons) {
        IntSummaryStatistics ageSummary = persons
                .stream().collect(Collectors.summarizingInt(p -> p.age));
        System.out.println(ageSummary);
    }

    private static void test5(List<Person> persons) {
        String names = persons.stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
        System.out.println(names);
    }

    private static void test6(List<Person> persons) {
        Map<Integer, String> map = persons.stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2
                ));
        System.out.println(map);
    }

    private static void test7(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "), //supplier
                        (j, p) -> j.add(p.name.toUpperCase()), //accumulator
                        (j1, j2) -> j1.merge(j2),              //combiner
                        StringJoiner::toString                 //finisher
                );
        String names = persons.stream()
                .collect(personNameCollector);
        System.out.println(names);

    }

    private static void test8(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> {
                            System.out.println("supplier");
                            return new StringJoiner(" | ");
                        },
                        (j, p) -> {
                            System.out.format("accumulator: p=%s; j=%s\n", p, j);
                            j.add(p.name.toUpperCase());
                        },
                        (j1, j2) -> {
                            System.out.println("merge");
                            return j1.merge(j2);
                        },
                        j -> {
                            System.out.println("finisher");
                            return j.toString();
                        }
                );
        String names = persons.stream().collect(personNameCollector);
        System.out.println(names);
    }

    private static void test9(List<Person> persons) {
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> {
                            System.out.println("supplier");
                            return new StringJoiner(" | ");
                        },
                        (j, p) -> {
                            System.out.format("accumulator: p=%s; j=%s\n", p, j);
                            j.add(p.name.toUpperCase());
                        },
                        (j1, j2) -> {
                            System.out.println("merge");
                            return j1.merge(j2);
                        },
                        j -> {
                            System.out.println("finisher");
                            return j.toString();
                        }
                );
        String names = persons.parallelStream().collect(personNameCollector);
        System.out.println(names);
    }

    //JDK1.8 时，添加了一个新的用于字符串连接的类，专门用于这种需要 分隔符 的场合，
    // 它就是 StringJoiner。StringJoiner 在构造时可以指定一个分隔符（delimiter），
    // 然后每连接一个元素它便会加上一个 delimiter，使用 StringJoiner 改写 formatList：
    public static String formatList(List<String> list, String delimiter) {
        StringJoiner result = new StringJoiner(delimiter);
        for (String str : list) {
            result.add(str);
        }
        return result.toString();
    }

    public static String formatList(
            List<String> list, String delimiter, String prefix, String suffix) {

        StringJoiner result = new StringJoiner(delimiter, prefix, suffix);
        for (String str : list) {
            result.add(str);
        }
        return result.toString();
    }


    public static void formatStr() {
        formatList(Arrays.asList("a", "b", "c"), ",");
        //内部使用StringJoiner
        String.join(",", Arrays.asList("a", "b", "c"));
        //查看 StringJoiner 的构造方法，发现 StringJoiner 除了指定 分隔符 的构造方法，
        //还有一个可以指定 分隔符、前缀和后缀 的构造方法
        formatList(Arrays.asList("a", "b", "c"), ",", "{", "}");

    }
}
