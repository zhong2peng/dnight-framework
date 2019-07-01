/**
 * @author ZHONGPENG769
 * @date 2019/7/1
 */
public class Solution {

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * For example:
     * Given array A = [2,3,1,1,4]
     * <p>
     * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     * <p>
     * 这道题还是跳跃游戏，每一位置的取值代表能跳到的最远的位置
     * 每次可以向后面跳跃的格子数等于当前的点数。求最少需要多少步就能调大最后的格子。
     * <p>
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //记录跳跃的次数
        int jump = 0;
        //记录当前可以到达的最远的位置
        int currentMax = 0;
        //下一次可以到达的最远的位置
        int nextMax = 0;
        //记录处理的位置
        int i = 0;

        while (currentMax - i + 1 > 0) {
            jump++;
            for (; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) {
                    return jump;
                }
            }
            // 本次处理不能使移动位增加，并且不能到达最末位置，说明永远到不了最后的位置
            if (currentMax == nextMax) {
                return Integer.MAX_VALUE;
            }
            // 更新当前可以移动的最远位置
            currentMax = nextMax;
        }
        return 0;
    }
}
