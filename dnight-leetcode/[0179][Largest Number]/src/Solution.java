import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZHONGPENG769
 * @date 2019/9/18
 */
public class Solution {

    /**
     * Given a list of non negative integers, arrange them such that they form the largest number.
     * <p>
     * Example 1:
     * <p>
     * Input: [10,2]
     * Output: "210"
     * Example 2:
     * <p>
     * Input: [3,30,34,5,9]
     * Output: "9534330"
     * Note: The result may be very large, so you need to return a string instead of an integer.
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i + j;
                String s2 = j + i;
                return s1.compareTo(s2);
            }
        });
        if (strs[strs.length - 1].charAt(0) == '0') {
            return "0";
        }
        String res = new String();
        for (int i = 0; i < strs.length; i++) {
            res = strs[i] + res;
        }
        return res;
    }
}
