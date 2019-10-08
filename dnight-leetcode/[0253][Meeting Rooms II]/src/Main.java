/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval();
        intervals[1] = new Interval();
        intervals[2] = new Interval();
        intervals[0].start = 0;
        intervals[0].end = 30;
        intervals[1].start = 5;
        intervals[1].end = 10;
        intervals[2].start = 15;
        intervals[2].end = 20;
        int i = solution.minMeetingRooms(intervals);
        System.out.println(i);
    }
}
