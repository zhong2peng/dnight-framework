import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/10/25
 */
public class Solution {

    /**
     * A binary watch has 4 LEDs on the top which represent the hours (0-11),
     * and the 6 LEDs on the bottom represent the minutes (0-59).
     * <p>
     * Each LED represents a zero or one, with the least significant bit on the right.
     * For example, the above binary watch reads "3:25".
     * <p>
     * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
     * <p>
     * Example:
     * <p>
     * Input: n = 1
     * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> hourSet = generate(hours, i);
            List<Integer> minuteSet = generate(minutes, num - i);
            for (Integer h : hourSet) {
                if (h > 11) {
                    continue;
                }
                for (Integer m : minuteSet) {
                    if (m > 59) {
                        continue;
                    }
                    result.add(h + (m < 10 ? ":0" : ":") + m);
                }
            }
        }
        return result;
    }

    private List<Integer> generate(int[] array, int count) {
        List<Integer> resSet = new LinkedList<>();
        backTrace(array, resSet, 0, 0, count);
        return resSet;
    }

    private void backTrace(int[] array, List<Integer> resSet, int sum, int pos, int count) {
        if (count == 0) {
            resSet.add(sum);
        } else {
            for (int i = pos; i < array.length; i++) {
                backTrace(array, resSet, sum + array[i], i + 1, count - 1);
            }
        }
    }

    int[] hours = {1, 2, 4, 8}; //4
    int[] minutes = {1, 2, 4, 8, 16, 32}; // 6


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.readBinaryWatch(2);
        for (String str : strings) {
            System.out.println(str);
        }

    }
}
