import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution1 {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(2, 1, n, result, list);
        return result;
    }

    private void helper(int start, int product, int n, List<List<Integer>> result, List<Integer> cur) {
        if (start > n || product > n) {
            return;
        }

        if (product == n) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < n; i++) {
            if (i * product > n) {
                break;
            }
            if (n % i == 0) {
                cur.add(i);
                helper(i, i * product, n, result, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
