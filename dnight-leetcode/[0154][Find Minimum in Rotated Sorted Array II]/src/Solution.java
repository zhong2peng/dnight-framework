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
     * The array may contain duplicates.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,3,5]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [2,2,2,0,1]
     * Output: 0
     * Note:
     * <p>
     * This is a follow up problem to Find Minimum in Rotated Sorted Array.
     * Would allow duplicates affect the run-time complexity? How and why?
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                // nums[mid] == nums[r]
                r--;
            }
        }
        return nums[l];
    }
}
