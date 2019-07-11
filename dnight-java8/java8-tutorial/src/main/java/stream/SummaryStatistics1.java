package stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/11
 */
public class SummaryStatistics1 {

    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("highest prime number in list: " + stats.getMax());
        System.out.println("lowest prime number in list: " + stats.getMin());
        System.out.println("Sum of all prime numbers :" + stats.getSum());
        System.out.println("Average of all prime numbers: " + stats.getAverage());
    }
}
