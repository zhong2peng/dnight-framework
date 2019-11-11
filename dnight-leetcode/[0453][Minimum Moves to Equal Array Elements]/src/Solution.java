/**
 * @author ZHONGPENG769
 * @date 2019/11/11
 */
public class Solution {

    /**
     * Given a non-empty integer array of size n,
     * find the minimum number of moves required to make all array elements equal,
     * where a move is incrementing n - 1 elements by 1.
     *
     * Example:
     *
     * Input:
     * [1,2,3]
     *
     * Output:
     * 3
     *
     * Explanation:
     * Only three moves are needed (remember each move increments two elements):
     *
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     *
     * n-1个元素加一，剩下的一个元素不变。等价于1个元素加一，剩下n-1个元素不变
     * 假设数组的长度为n， 每次移动都会是其中n-1的元素加1。多少次移动后，数组的元素全部相等。
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int tmp:nums){
            if (min > tmp){
                min = tmp;
            }
        }
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i] - min;
        }
        return sum;
    }
}
