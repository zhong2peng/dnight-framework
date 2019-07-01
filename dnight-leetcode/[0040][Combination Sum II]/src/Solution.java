import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用一次。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。
     * <p>
     * 和39题一模一样，注意他有重复数，需要去除重复的结果.
     * <p>
     * 还要注意回溯是往后回溯，不是原地回溯了
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    /**
     * @param list     结果集
     * @param tempList 临时结果集
     * @param nums     可选值数组
     * @param remain   剩余值
     * @param start    可选值的起始下标
     */
    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new LinkedList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                // 如果上一轮循环没有选nums[i]，则本次循环就不能再选nums[i]，
                // 确保nums[i] 最多只用一次
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                // 数值不可以被重用
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
