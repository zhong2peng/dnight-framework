package time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class LocalDateTime1 {

    public static void main(String[] args) {
        //LocalDateTime类是一个没有时区的日期时间的构建。
        LocalDateTime time = LocalDateTime.of(2019, Month.JULY, 31, 23, 59, 59);
        DayOfWeek dayOfWeek = time.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month month = time.getMonth();
        System.out.println(month);

        long minuteOfDay = time.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        //Instant实例表示时间线上的一个点,参考点是标准的Java纪元(epoch)，即1970-01-01T00：00：00Z（1970年1月1日00:00 GMT）。
        Instant instant = time.atZone(ZoneId.systemDefault()).toInstant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd, yyyy - HH:mm");
        LocalDateTime parse = LocalDateTime.parse("07 25, 2019 - 09:00", formatter);
        System.out.println(parse);
    }
}
