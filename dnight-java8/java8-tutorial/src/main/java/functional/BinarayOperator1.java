package functional;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class BinarayOperator1 {

    public static void main(String[] args) {
        int value1 = 12;
        int value2 = 6;
        System.out.println("min = " + min(value1, value2, (a, b) -> a - b));
        System.out.println("max = " + max(value1, value2, (a, b) -> a - b));
    }

    public static int min(int a, int b, Comparator<Integer> c) {
        return BinaryOperator.minBy(c).apply(a, b);
    }

    public static int max(int a, int b, Comparator<Integer> c) {
        return BinaryOperator.maxBy(c).apply(a, b);
    }
}
