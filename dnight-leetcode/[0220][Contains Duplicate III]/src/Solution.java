import java.util.TreeSet;

/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
     * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is
     * at most k.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1], k = 3, t = 0
     * Output: true
     * Example 2:
     * <p>
     * Input: nums = [1,0,1,1], k = 1, t = 2
     * Output: true
     * Example 3:
     * <p>
     * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
     * Output: false
     * <p>
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
     * 并且 i 和 j 之间的差的绝对值最大为 ķ。
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        set.add((long) nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i > k) set.remove((long) nums[i - k - 1]);
            long left = (long) nums[i] - t;
            long right = (long) nums[i] + t;
            if (left <= right && !set.subSet(left, right + 1).isEmpty()) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }
}
