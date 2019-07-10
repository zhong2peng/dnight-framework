package functional;

import util.Score;

import java.util.function.BiFunction;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class BiFunction1 {

    public static void main(String[] args) {
        Score score = new Score("john", 90L, 90L);
        BiFunction<String, Long, String> biFunction = (t1, t2) -> t1 + "的成绩单，chniese " + t2;

        System.out.println(biFunction.apply(score.getName(), score.getChinese()));
    }
}
