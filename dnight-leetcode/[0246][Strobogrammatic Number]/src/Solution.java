import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHONGPENG769
 * @date 2019/10/8
 */
public class Solution {

    /**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees
     * (looked at upside down).
     * <p>
     * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
     * <p>
     * For example, the numbers "69", "88", and "818" are all strobogrammatic.
     *
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('0', '0');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (!map.containsKey(num.charAt(right)) || num.charAt(left) != map.get(num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
