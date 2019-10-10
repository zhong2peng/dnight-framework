import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/10/10
 */
public class Solution {

    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
     * find the one that is missing from the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,0,1]
     * Output: 2
     * Example 2:
     * <p>
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Note:
     * Your algorithm should run in linear runtime complexity.
     * Could you implement it using only constant extra space complexity?
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int tmp : nums) {
            sum += tmp;
        }
        return (1 + n) * n / 2 - sum;
    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums3 = {0};
        System.out.println(solution.missingNumber1(nums1));
        System.out.println(solution.missingNumber1(nums2));
        System.out.println(solution.missingNumber1(nums3));
    }
}
