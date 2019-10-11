import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/11
 */
public class ZigzagIterator {

    /**
     * Given two 1d vectors, implement an iterator to return their elements alternately.
     * <p>
     * For example, given two 1d vectors:
     * <p>
     * v1 = [1, 2]
     * v2 = [3, 4, 5, 6]
     * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
     * [1, 3, 2, 4, 5, 6].
     * <p>
     * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
     * <p>
     * Clarification for the follow up question - Update (2015-09-18):
     * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
     * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
     * <p>
     * [1,2,3]
     * [4,5,6,7]
     * [8,9]
     * It should return [1,4,8,2,5,9,3,6,7].
     */

    List<Iterator<Integer>> iters = new ArrayList<Iterator<Integer>>();

    int count = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (!v1.isEmpty()) {
            iters.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            iters.add(v2.iterator());
        }
    }

    public int next() {
        int x = iters.get(count).next();
        if (!iters.get(count).hasNext()) {
            iters.remove(count);
        } else {
            count++;
        }
        if (iters.size() != 0) {
            count %= iters.size();
        }
        return x;
    }

    public boolean hasNext() {
        return !iters.isEmpty();
    }
}
