import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/15
 */
public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        if (nums != null) {
            Arrays.sort(nums);
            // i 表示子元素个数
            for (int i = 0; i <= nums.length; i++) {
                subsets(nums, 0, i, result, curr);
            }
        }
        return result;
    }

    /**
     * 找元素有n个的子集数
     *
     * @param nums   元素集合
     * @param idx    可取元素的起始位置
     * @param n      集合元素个数
     * @param result 结果集
     * @param curr   临时解
     */
    private void subsets(int[] nums, int idx, int n, List<List<Integer>> result, List<Integer> curr) {
        if (n == 0) {
            result.add(new LinkedList<>(curr));
            return;
        }
        //还没有处理完，处理下一个元素
        for (int i = idx; i < nums.length - n + 1; i++) {
            curr.add(nums[i]);
            subsets(nums, idx + 1, n - 1, result, curr);
            curr.remove((Integer) nums[i]);
        }
    }
}
