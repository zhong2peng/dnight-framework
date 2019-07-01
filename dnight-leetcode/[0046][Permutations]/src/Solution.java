import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * <pre>
     * 原题
     * Given a collection of numbers, return all possible permutations.
     * For example,
     * [1,2,3] have the following permutations:
     * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     *
     * 题目大意
     * 给定一个数组，返回他的所有排列。
     *
     * 解题思路
     * 使用分治法求解。
     * </pre>
     *
     * @param num
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums != null) {
            permute(0, nums, result);
        }
        return result;
    }

    /**
     * @param i      当前位置
     * @param nums   数组
     * @param result 存放结果
     */
    private void permute(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int n : nums) {
                l.add(n);
            }
            result.add(l);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, j, i);
                permute(i + 1, nums, result);
                swap(nums, j, i);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
