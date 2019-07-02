import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/2
 */
public class Solution {

    /**
     * <pre>
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * For example,
     * Given [1,3],[2,6],[8,10],[15,18],
     * return [1,6],[8,10],[15,18].
     *
     * 题目大意，
     * 给定一个区间集合，合并有重叠的区间
     *
     * 解题思路：
     * 先对区间进行排序，按开始点进行排序，再一个一个进行合并
     * </pre>
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        if (intervals == null || intervals.size() < 1) {
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval prev = null;
        for (Interval item : intervals) {
            if (prev == null || prev.end < item.start) {
                result.add(item);
                prev = item;
            } else if (prev.end < item.end) {
                prev.end = item.end;
            }
        }
        return result;
    }
}
