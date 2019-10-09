import java.util.Arrays;

/**
 * @author ZHONGPENG769
 * @date 2019/10/9
 */
public class Solution {

    /**
     * Given an array of n integers nums and a target, find the number of index triplets i, j, k
     * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
     * <p>
     * For example, given nums = [-2, 0, 1, 3], and target = 2.
     * Return 2. Because there are two triplets which sums are less than 2:
     * [-2, 0, 1]
     * [-2, 0, 3]
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length < 3) {
            return count;
        }
        Arrays.sort(nums);
        int len = nums.length - 1;
        int i = 0, j, k = len;
        while (i >= 0 && i < k && k > 0) {
            j = i + 1;
            if (nums[i] + nums[j] + nums[k] >= target) {
                k--;
            } else {
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] >= target) {
                        k--;
                        j = i + 1;
                    } else {
                        count++;
                        j++;
                    }
                }
            }
            i++;
            k = len;
        }
        return count;
    }

    /**
     * 优化
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller1(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    count += k - j; // -2,0,3 可以；-2,0,1也可以
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        System.out.println(new Solution().threeSumSmaller1(nums, 2));
    }
}
