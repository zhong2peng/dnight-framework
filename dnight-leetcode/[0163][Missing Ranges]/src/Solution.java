import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
     * <p>
     * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
     *
     * @param A
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (A == null) {
            if (lower == upper) {
                res.add(String.valueOf(lower));
            } else {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        for (int i = 0; i < A.length; i++) {
            while (i < A.length && A[i] == lower) {
                lower++;
                i++;
            }
            if (i >= A.length) {
                break;
            }
            if (A[i] == lower + 1) {
                res.add(String.valueOf(lower));
            } else {
                res.add("" + lower + "->" + (A[i] - 1));
            }
            lower = A[i] + 1;
        }

        if (lower == upper) {
            res.add(String.valueOf(lower));
        } else {
            res.add("" + lower + "->" + upper);
        }
        return res;
    }
}
