/**
 * @author ZHONGPENG769
 * @date 2019/9/29
 */
public class Solution {

    /**
     * Given an array nums of n integers where n > 1,
     * return an array output such that output[i] is equal to the product of all the elements of nums
     * except nums[i].
     * <p>
     * Example:
     * <p>
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: Please solve it without division and in O(n).
     * <p>
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as extra space
     * for the purpose of space complexity analysis.)
     * <p>
     * 给定我们一个数组，让我们返回一个新数组，对于每一个位置上的数是其他位置上数的乘积
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int res = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                res = res * num;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    nums[i] = res;
                } else {
                    nums[i] = 0;
                }
            } else if (zeroCount > 1) {
                nums[i] = 0;
            } else {
                nums[i] = res / nums[i];
            }
        }
        return nums;
    }
}
