import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
     * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     * Example 2:
     * <p>
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     * Example 3:
     * <p>
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     * <p>
     * 如果数组中存在相等的两个数，而且他们的位置差不超过k，那么返回true，否则返回false
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean flag = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    flag = true;
                    break;
                }
            }
            map.put(nums[i], i);
        }
        return flag;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
