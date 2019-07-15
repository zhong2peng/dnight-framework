import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given two integers n and k, return all possible combinations of k numbers out of 1 … n.
     * For example,
     * If n = 4 and k = 2, a solution is:
     *
     * [
     *  [2,4],
     *  [3,4],
     *  [2,3],
     *  [1,2],
     *  [1,3],
     *  [1,4],
     * ]
     *
     * 题目大意
     * 给定两个数n和k，求从1-n中k个数的所有组合。
     *
     * 解题思路
     * 使用广度优化遍历算法
     * </pre>
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> current = new LinkedList<>();
        dfs(1, n, k, current, result);
        return result;
    }

    private void dfs(int start, int end, int k, List<Integer> current, List<List<Integer>> result) {
        if (k == current.size()) {
            result.add(new LinkedList<>(current));
            return;
        }
        for (int i = start; i <= end; i++) {
            current.add(i);
            dfs(i + 1, end, k, current, result);
            current.remove((Integer) i);
        }
    }

    private List<List<Integer>> result;
    private List<Integer> l;

    /**
     * 递归分治
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine1(int n, int k) {
        result = new LinkedList<>();
        if (n > 0 && k > 0 && n >= k) {
            l = new LinkedList<>();
            combine1(1, n, k);
        }
        return result;
    }

    /**
     * 求组合
     *
     * @param start 可选择的数开始位置
     * @param end   可选择的数的结束位置
     * @param num   在[start, end]中选择的数的数目
     */
    private void combine1(int start, int end, int num) {
        if (num == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer i : l) {
                tmp.add(i);
            }
            result.add(tmp);
            return;
        }

        int endFirst = end - num + 1;
        for (int i = start; i <= endFirst; i++) {
            l.add(i);
            combine1(i + 1, end, num - 1);
            l.remove((Integer) i);
        }
    }
}
