import java.util.HashSet;

/**
 * @author ZHONGPENG769
 * @date 2019/9/27
 */
public class Solution {

    /**
     * Given an array of integers, find if the array contains any duplicates.
     * <p>
     * Your function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,1]
     * Output: true
     * Example 2:
     * <p>
     * Input: [1,2,3,4]
     * Output: false
     * Example 3:
     * <p>
     * Input: [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            int j = i / 8;
            int k = i % 8;
            int check = 1 << k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j] |= check;
        }
        return false;
    }
}


