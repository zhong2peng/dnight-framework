/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class NumArray {

    int[] nums;

    /**
     * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
     * <p>
     * Example:
     * Given nums = [-2, 0, 3, -5, 2, -1]
     * <p>
     * sumRange(0, 2) -> 1
     * sumRange(2, 5) -> -1
     * sumRange(0, 5) -> -3
     * Note:
     * You may assume that the array does not change.
     * There are many calls to sumRange function.
     */

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int start = i, len = nums.length; start <= j && start < len; start++) {
            sum += nums[start];
        }
        return sum;
    }
}
