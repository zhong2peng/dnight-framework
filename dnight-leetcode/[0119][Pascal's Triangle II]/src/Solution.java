import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/5
 */
public class Solution {

    /**
     * Given a non-negative index k where k ≤ 33,
     * return the kth index row of the Pascal's triangle.
     * <p>
     * Note that the row index starts from 0.
     * <p>
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     * <p>
     * Example:
     * <p>
     * Input: 3
     * Output: [1,3,3,1]
     * <p>
     * O(k) extra space
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
            result.add(1);
        }
        return result;
    }
}
