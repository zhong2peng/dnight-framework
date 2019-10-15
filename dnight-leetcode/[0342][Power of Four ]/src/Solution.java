/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class Solution {

    /**
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        double a = Math.log(num) / Math.log(4);
        return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
    }
}
