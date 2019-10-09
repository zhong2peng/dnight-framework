import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution {

    /**
     * Numbers can be regarded as product of its factors. For example,
     * <p>
     * 8 = 2 x 2 x 2;
     * = 2 x 4.
     * Write a function that takes an integer n and return all possible combinations of its factors.
     * <p>
     * Note:
     * <p>
     * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
     * You may assume that n is always positive.
     * Factors should be greater than 1 and less than n.
     * <p>
     * Examples:
     * input: 1
     * output:
     * []
     * <p>
     * input: 37
     * output:
     * []
     * <p>
     * input: 12
     * output:
     * [
     * [2, 6],
     * [2, 2, 3],
     * [3, 4]
     * ]
     * <p>
     * input: 32
     * output:
     * [
     * [2, 16],
     * [2, 2, 8],
     * [2, 2, 2, 4],
     * [2, 2, 2, 2, 2],
     * [2, 4, 4],
     * [4, 8]
     * ]
     *
     * @param n
     * @return
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, 2, new ArrayList<>(), result);
        return result;
    }

    private void helper(int n, int start, List<Integer> item, List<List<Integer>> result) {
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<>(item));
            }
            return;
        }

        // 从2至sqrt(n)
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                helper(n / i, i, item, result);
                item.remove(item.size() - 1);
            }
        }

        // 当start超过sqrt(n)时，start变成n，进行下一个递归
        item.add(n);
        helper(1, n, item, result);
        item.remove(item.size() - 1);
    }
}
