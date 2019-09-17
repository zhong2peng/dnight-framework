/**
 * @author ZHONGPENG769
 * @date 2019/9/17
 */
public class Solution {

    /**
     * A peak element is an element that is greater than its neighbors.
     * <p>
     * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
     * <p>
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * <p>
     * You may imagine that nums[-1] = nums[n] = -∞.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1]
     * Output: 2
     * Explanation: 3 is a peak element and your function should return the index number 2.
     * Example 2:
     * <p>
     * Input: nums = [1,2,1,3,5,6,4]
     * Output: 1 or 5
     * Explanation: Your function can return either index number 1 where the peak element is 2,
     * or index number 5 where the peak element is 6.
     * Note:
     * <p>
     * Your solution should be in logarithmic complexity.
     * <p>
     * 最左端和最右端元素均无限小，中间元素比两侧都要大，那么本题中一定存在一个峰元素。所以不管中间有多少波峰，只要找到峰元素，
     * 我们只需找到刚刚开始下降而未下降的位置。采用二分查找，查出这样一个位置即可，
     * 我们知道二分查找要比较的是 target 元素，本题的 target 元素是 mid 的后一个元素，即 nums[mid] 与 nums[mid+1] 进行比较：
     * 在一个无序的数组里找到一个peak元素，所谓peak，就是值比两边邻居大就可以了
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
