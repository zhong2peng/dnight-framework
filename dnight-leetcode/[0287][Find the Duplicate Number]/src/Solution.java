/**
 * @author ZHONGPENG769
 * @date 2019/10/12
 */
public class Solution {

    /**
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
     * prove that at least one duplicate number must exist.
     * Assume that there is only one duplicate number, find the duplicate one.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,3,4,2,2]
     * Output: 2
     * Example 2:
     * <p>
     * Input: [3,1,3,4,2]
     * Output: 3
     * Note:
     * <p>
     * You must not modify the array (assume the array is read only).
     * You must use only constant, O(1) extra space.
     * Your runtime complexity should be less than O(n^2).
     * There is only one duplicate number in the array, but it could be repeated more than once.
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            if (slow == nums[fast]) {
                return slow;
            }
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            if (slow == nums[slow]) {
                return slow;
            }
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
