import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class Solution {

    /**
     * Given two arrays, write a function to compute their intersection.
     * <p>
     * Example 1:
     * <p>
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     * <p>
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Note:
     * <p>
     * Each element in the result must be unique.
     * The result can be in any order.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int tmp : nums1) {
            set.add(tmp);
        }
        for (int tmp : nums2) {
            if (set.contains(tmp)) {
                res.add(tmp);
            }
        }
        if (!res.isEmpty()) {
            int[] nums = new int[res.size()];
            Iterator<Integer> iterator = res.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                nums[i++] = iterator.next();
            }
            return nums;
        }
        return new int[0];
    }
}
