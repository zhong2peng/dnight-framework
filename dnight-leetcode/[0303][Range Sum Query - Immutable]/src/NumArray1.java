/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class NumArray1 {

    int[] sums;

    public NumArray1(int[] nums) {
        int len = nums.length;
        sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j] - (i == 0 ? 0 : sums[i - 1]);
    }
}
