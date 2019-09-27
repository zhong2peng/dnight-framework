import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * <p>
     * Note:
     * <p>
     * All numbers will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Example 2:
     * <p>
     * Input: k = 3, n = 9
     * Output: [[1,2,6], [1,3,5], [2,3,4]]
     * <p>
     * 只是用１～９这几个数字，而且每个数字只能使用一次，要用k个不同的数字组成和为n的组合，问有多少中不同的组合方式。
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    // backtracking
    private void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int k, int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            nums.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, k, n, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(List<Integer> nums, int k, int n, int idx, List<Integer> path, List<List<Integer>> ans) {
        if (k <= 0 && n <= 0) {
            if (k == 0 && n == 0) {
                ans.add(path);
            }
            return;
        }
        for (int i = idx; i < nums.size(); i++) {
            List<Integer> p = new ArrayList<>(path);
            p.add(nums.get(i));
            dfs(nums, k - 1, n - nums.get(i), i + 1, p, ans);
        }
    }
}
