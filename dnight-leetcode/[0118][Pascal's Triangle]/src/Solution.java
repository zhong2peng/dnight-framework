import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     * <p>
     * Example:
     * <p>
     * Input: 5
     * Output:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> layout = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    layout.add(1);
                } else {
                    List<Integer> list = result.get(i - 1);
                    layout.add(list.get(j - 1) + list.get(j));
                }
            }
            result.add(layout);
        }
        return result;
    }

}
