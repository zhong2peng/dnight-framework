/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution {

    /**
     * Given an array of numbers nums, in which exactly two elements appear only once and
     * all the other elements appear exactly twice. Find the two elements that appear only once.
     * <p>
     * Example:
     * <p>
     * Input:  [1,2,1,3,2,5]
     * Output: [3,5]
     * Note:
     * <p>
     * The order of the result is not important. So in the above example, [5, 3] is also correct.
     * Your algorithm should run in linear runtime complexity.
     * Could you implement it using only constant space complexity?
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor = nums[0];
        // 异或运算符，去重
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int bit = xor & ~(xor - 1);
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & bit) > 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        result[0] = num1;
        result[1] = num2;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        new Solution().singleNumber(nums);
        System.out.println(3 ^ 5);
        System.out.println(~5);
        System.out.println(6 ^ ~5);
    }
}
