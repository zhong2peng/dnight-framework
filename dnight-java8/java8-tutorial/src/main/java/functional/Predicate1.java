package functional;

import util.Score;

import java.util.function.Predicate;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Predicate1 {

    public static void main(String[] args) {
        Score s1 = new Score("tom", 90L, 85L);
        Predicate<Score> p1 = (score) -> score.getChinese() > 90;
        Predicate<Score> p2 = score -> score.getMath() > 80;
        System.out.println(p1.and(p2).test(s1));
        System.out.println(p1.or(p2).test(s1));

    }
}
