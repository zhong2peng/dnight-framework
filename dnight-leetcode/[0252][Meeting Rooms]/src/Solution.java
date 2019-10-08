import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * Given an array of meeting time intervals consisting of start and end times
     * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
     * <p>
     * For example,
     * Given [[0, 30],[5, 10],[15, 20]],
     * return false.
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (i1, i2) ->
                i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end
        );
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}
