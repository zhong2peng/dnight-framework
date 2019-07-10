package time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class LocalDate1 {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        System.out.println("today: " + today);
        System.out.println("tomorrow: " + tomorrow);
        System.out.println("yesterday: " + yesterday);


    }
}
