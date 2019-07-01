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
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * <p>
     * [1,2,3,4]构建成回溯树如下状态，一次循环开始进入一个数，一次循环后pop出来一个数，形成一种对称性回溯
     * ```
     * 1
     * / | \
     * 12  13  14
     * /  |
     * 123 124 .....
     * ```
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    /**
     * 回溯法
     *
     * @param list    ：保存总的结果
     * @param tmpList ：保存临时结果
     * @param nums    ：输入的数组
     * @param remain  ：剩下的数
     * @param start   ：可用的值在数组中的起始位置
     */
    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tmpList, int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            //刚好够减
            list.add(new LinkedList<>(tmpList));
        } else {
            //从剩下的数中一个一个尝试
            for (int i = start; i < nums.length; i++) {
                //假定这个值是临时结果中的一个值
                tmpList.add(nums[i]);
                //处理下一步
                backtrack(list, tmpList, nums, remain - nums[i], i);
                //现场还原
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
