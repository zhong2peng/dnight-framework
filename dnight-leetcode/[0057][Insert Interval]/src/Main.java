import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(6, 9);
        Interval interval3 = new Interval(2, 5);

        List<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        List<Interval> insert = solution.insert(list, interval3);

        for (Interval interval : insert) {
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }

    }
}
