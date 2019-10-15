/**
 * @author ZHONGPENG769
 * @date 2019/10/15
 */
public class Solution {

    /**
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place
     * with O(1) extra memory.
     * <p>
     * You may assume all the characters consist of printable ascii characters.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     * <p>
     * Input: ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     *
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        String input = new String(s);
        for (int i = 0, len = s.length; i < len; i++) {
            s[i] = input.charAt(len - i - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
    }
}
