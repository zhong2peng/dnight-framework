import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
     * <p>
     * For example,
     * Given [[0, 30],[5, 10],[15, 20]],
     * return 2.
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) ->
                i1.start != i2.start ? i1.start - i2.start : i1.end - i2.end);

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (Interval interval : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(interval.end);
            } else {
                if (interval.start >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }
                heap.offer(interval.end);
            }
        }
        return count;
    }
}
