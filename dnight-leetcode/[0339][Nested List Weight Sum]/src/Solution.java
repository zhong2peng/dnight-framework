import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class Solution {

    /**
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
     * <p>
     * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
     * <p>
     * Example 1:
     * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
     * 1*2*2*2+2*1
     * <p>
     * Example 2:
     * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
     *
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        int[] sum = new int[0];
        depthSum(nestedList, 1, sum);
        return sum[0];
    }

    public void depthSum(List<NestedInteger> nestedList, int depth, int[] sum) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum[0] += nestedInteger.getInteger() * depth;
            } else {
                depthSum(nestedInteger.getList(), depth + 1, sum);
            }
        }
    }
}
