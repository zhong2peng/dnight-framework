package lambda;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * @author ZHONGPENG769
 * @date 2019/10/24
 */
public class Test {

    public interface Worker {
        String work();
    }

    public static void test(Worker worker) {
        String work = worker.work();
        System.out.println(work);
    }

    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 185;
        Student student = new Student("恐龙", 23, 175);
        System.out.println("恐龙身高>185, " + predicate.test(student.getHigh()));
        Consumer<String> consumer = System.out::println;
        consumer.accept("go go go!");
        Function<Student, String> function = Student::getName;
        String name = function.apply(student);
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());
        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);

        BinaryOperator<Integer> operator = (x, y) -> x * y;
        Integer integer = operator.apply(1, 3);
        System.out.println(integer);
        test(() -> "Something happened!!!");
    }
}
