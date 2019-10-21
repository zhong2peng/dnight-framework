/**
 * @author ZHONGPENG769
 * @date 2019/10/16
 */
public class Solution {

    /**
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     * <p>
     * Note: Do not use any built-in library function such as sqrt.
     * <p>
     * Example 1:
     * <p>
     * Input: 16
     * Output: true
     * Example 2:
     * <p>
     * Input: 14
     * Output: false
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;

        long low = 1,
                high = num / 2,
                mid = 0;

        long nums = (long) num;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if ((mid * mid) == nums)
                return true;
            else if ((mid * mid) < nums)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
