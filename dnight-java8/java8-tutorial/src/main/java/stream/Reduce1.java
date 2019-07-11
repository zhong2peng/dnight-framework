package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class Reduce1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int sum1 = list.stream().mapToInt(t -> t).sum();
        System.out.println(sum1);

        //与第一种变形相同的是都会接受一个BinaryOperator函数接口，不同的是其会接受一个identity参数，用来指定Stream循环的初始值。如果Stream为空，就直接返回该值。
        int sum2 = list.stream().mapToInt(t -> t).reduce(0, (x, y) -> x + y);
        System.out.println(sum2);

        /**
         * reduce 操作可以实现从Stream中生成一个值，其生成的值不是随意的，而是根据指定的计算模型。比如，之前提到count、min和max方
         * 法，因为常用而被纳入标准库中。事实上，这些方法都是reduce操作。
         *
         * reduce方法有三个override的方法：
         *
         * Optional<T> reduce(BinaryOperator<T> accumulator);
         * T reduce(T identity, BinaryOperator<T> accumulator);
         * <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner);
         */
        List<Integer> constBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        //可以看到reduce方法接受一个函数，这个函数有两个参数，第一个参数是上次函数执行的返回值（也称为中间结果），第二个参数是stream中的元素
        double bill = constBeforeTax.stream().map(cost -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println(bill);
    }
}
