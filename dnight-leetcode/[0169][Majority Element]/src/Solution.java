import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class Solution {

    /**
     * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * <p>
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     * <p>
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return ret;
    }

    public int majorityElement2(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> (31 - i) & 1) == 1) {
                    bit[i]++;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            ret += bit[i] * (1 << (31 - i));
        }
        return ret;
    }
}
