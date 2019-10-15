import java.util.*;

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
     * Output: [2,2]
     * Example 2:
     * <p>
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Note:
     * <p>
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     * Follow up:
     * <p>
     * What if the given array is already sorted? How would you optimize your algorithm?
     * What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums1.length; i < len; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 0);
            }
            map.put(nums1[i], map.get(nums1[i]) + 1);
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0, len = nums2.length; i < len; i++) {
            if (map.containsKey(nums2[i])) {
                Integer tmp = map.get(nums2[i]) - 1;
                if (tmp == 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], tmp);
                }
                list.add(nums2[i]);
            }
        }
        if (list.size() > 0) {
            int[] res = new int[list.size()];
            int index = 0;
            for (Integer i : list) {
                res[index++] = i;
            }
            return res;
        }
        return new int[0];
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums1;
        }
        if (nums2.length == 0) {
            return nums2;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
