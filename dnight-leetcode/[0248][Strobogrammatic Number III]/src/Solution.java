import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
     * <p>
     * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
     * <p>
     * For example,
     * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
     * <p>
     * Note:
     * Because the range might be a large number, the low and high numbers are represented as string.
     *
     * @param low
     * @param high
     * @return
     */
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> result = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            result.addAll(helper(i, i));
        }
        for (String str : result) {
            if (str.length() == low.length() && str.compareTo(low) < 0 ||
                    str.length() == high.length() && str.compareTo(high) > 0) {
                continue;
            }
            count++;
        }
        return count;
    }

    private List<String> helper(int n, int max) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("1", "8", "0"));
        }

        List<String> list = helper(n - 2, max);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != max) {
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("8" + s + "8");
            result.add("6" + s + "9");
            result.add("9" + s + "6");
        }
        return result;

    }
}
