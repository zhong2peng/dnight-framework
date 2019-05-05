import java.util.Arrays;

/**
 * Author: dnight
 * Date: 2019/5/5 23:08
 */
public class Solution {

    /**
     * <pre>
     * Given an array S of n integers, find three integers in S such that the sum is
     * closest to a given number, target. Return the sum of the three integers. You
     * may assume that each input would have exactly one solution.
     *
     * For example,
     * given array S = {-1 2 1 -4}, and target = 1.
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     *
     * 题目大意：
     * 给定包含n个整数数组S，找到S中的三个整数，从而使之和最接近给定的数。
     * 返回三个整数的总和。你可以假设每个输入将有一个确切的解决。
     *
     * 解题思路：
     * 和3sum类似求解
     * </pre>
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target){
        // 记录最小的差值
        long minDiff = Long.MAX_VALUE;
        // 记录最小差值对应的三个整数和和
        long result = 0;
        // 每次求得的差值
        long diff;
        // 每次求得的三个整数的和
        long sum;

        Arrays.sort(nums);
        for (int i = 0; i<nums.length - 2; i++){
            int j = i+1;
            int k = nums.length-1;
            while (j < k){
                sum = nums[j] + nums[k] + nums[i];
                diff = Math.abs(target - sum);

                if (diff == 0){
                    return (int)sum;
                }
                // 如果当前的差值比之前记录的差值小
                if (diff < minDiff){
                    // 更新最小的差值
                    minDiff = diff;
                    // 更新最小差值对应的和
                    result = sum;
                    // 以上的设置在下一次元素处理时生效
                }
                if (sum > target){
                    // 和大于target
                    k--;
                }else {
                    // 和小于target
                    j++;
                }

            }
        }
        return (int)result;
    }
}
