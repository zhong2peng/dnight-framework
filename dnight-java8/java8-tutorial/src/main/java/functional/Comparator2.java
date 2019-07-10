package functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Comparator2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 6, 1, 9, 10, 3);
        System.out.println(" min -> max");
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(list);
        System.out.println("max -> min");
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);

    }
}
