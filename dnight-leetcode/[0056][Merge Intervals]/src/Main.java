import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);
        List<Interval> list = new LinkedList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        List<Interval> merge = solution.merge(list);
        for (Interval interval : merge) {
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }
    }
}
