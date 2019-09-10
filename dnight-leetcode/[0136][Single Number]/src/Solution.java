/**
 * @author ZHONGPENG769
 * @date 2019/9/10
 */
public class Solution {

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * <p>
     * Note:
     * <p>
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * <p>
     * Example 1:
     * <p>
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,1,2,1,2]
     * Output: 4
     * <p>
     * 给定一个数组，每个元素都出现2次除了其中的一个，找出只出现一次的数字
     * 注意：算法必须是线性时间复杂度，可以不使用额外空间实现吗？
     * <p>
     * 解题思路：使用异或运算
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
