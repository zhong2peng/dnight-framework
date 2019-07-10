package functional;

import util.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Comparator1 {

    public static void main(String[] args) {
        List<Score> list = new ArrayList<>();
        list.add(new Score("john", 90L, 91L));
        list.add(new Score("tom", 85L, 90L));
        list.add(new Score("smith", 90L, 96L));
        list.add(new Score("dnight", 85L, 70L));

        Collections.sort(list, Comparator.comparing(Score::getChinese).thenComparing(Score::getMath));
        System.out.println("chinese,math :");
        list.forEach(System.out::println);

        Comparator c1 = Comparator.comparing(Score::getChinese).reversed();
        Comparator c2 = Comparator.comparing(Score::getMath).reversed();
        Collections.sort(list, c1.thenComparing(c2));
        System.out.println("chinese,math : ");
        list.forEach(System.out::println);
    }
}
