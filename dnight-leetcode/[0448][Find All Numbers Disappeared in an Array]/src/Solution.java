import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/11/11
 */
public class Solution {

    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
     * some elements appear twice and others appear once.
     *
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * Could you do it without extra space and in O(n) runtime?
     * You may assume the returned list does not count as extra space.
     *
     * Example:
     *
     * Input:
     * [4,3,2,7,8,2,3,1]
     *
     * Output:
     * [5,6]
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return list;
        }
        Arrays.sort(nums);
        int n = nums.length, start = 1;
        for (int i = 0; i<n; i++){
            while (nums[i] > start){
                list.add(start);
                start++;
            }
            if (nums[i] == start){
                start++;
            }
        }
        while (start <= n){
            list.add(start);
            start++;
        }
        return list;

    }

    public List<Integer> findDisappearedNumbers1(int[] nums){
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers(nums));
    }

}
