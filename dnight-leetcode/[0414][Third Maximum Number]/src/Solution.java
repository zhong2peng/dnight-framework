import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/10/28
 */
public class Solution {

    /**
     * Given a non-empty array of integers, return the third maximum number in this array.
     * If it does not exist, return the maximum number. The time complexity must be in O(n).
     * <p>
     * Example 1:
     * Input: [3, 2, 1]
     * <p>
     * Output: 1
     * <p>
     * Explanation: The third maximum is 1.
     * Example 2:
     * Input: [1, 2]
     * <p>
     * Output: 2
     * <p>
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     * Input: [2, 2, 3, 1]
     * <p>
     * Output: 1
     * <p>
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int tmp = nums[nums.length - 1];
        int res = tmp, size = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == tmp) {
                continue;
            }
            tmp = nums[i];
            size++;
            if (size == 3) {
                return nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        Solution solution = new Solution();
        int i = solution.thirdMax(nums);
        System.out.println(i);
    }
}
