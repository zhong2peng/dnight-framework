/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     * <p>
     * Find the minimum element.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,4,5,1,2]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,5,6,7,0,1,2]
     * Output: 0
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            // if it is less than previous one, then it is minimum
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            //  If it is greater than both left and right element, then minimum element should be on its right, otherwise on its left.
            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // end 可能为负数，而start绝对在数组索引范围内
        // 如果在start~end之间未找到min，那证明是升序，所以初始位置为最小
        return nums[start];
    }
}
