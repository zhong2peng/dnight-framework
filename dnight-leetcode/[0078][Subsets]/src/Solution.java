import java.util.Arrays;
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
     * Given a set of distinct integers, nums, return all possible subsets.
     * Note:
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * For example,
     * If nums = [1,2,3], a solution is:
     *
     * [
     *  [3],
     *  [1],
     *  [2],
     *  [1,2,3],
     *  [1,3],
     *  [2,3],
     *  [1,2],
     *  []
     * ]
     *
     * 题目大意
     * 给定一个不同数字的数组，返回它的所有子集。
     *
     * 解题思路
     * 先对数组中的元素进行排序，然后使用广度优化遍历。
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        if (nums != null) {
            Arrays.sort(nums);
            dfs(nums, 0, result, curr);
        }
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> curr) {
        result.add(new LinkedList<>(curr));
        for (int j = index; j < nums.length; j++) {
            curr.add(nums[j]);
            dfs(nums, j + 1, result, curr);
            curr.remove((Integer) nums[j]);
        }
    }
}
